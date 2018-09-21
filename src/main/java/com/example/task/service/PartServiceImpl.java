package com.example.task.service;

import com.example.task.dao.PartDao;
import com.example.task.entity.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PartServiceImpl implements PartService {

    @Autowired
    public PartDao partdao;

    public List<Part> findAll(int page) {
        return partdao.findAll((page-1) * 10 );
    }
    public List<Part> findAll(int page, boolean required) {
        return partdao.findAll((page-1) * 10, required);
    }
    public List<Part> findAll() {return partdao.findAll();}

    public List<Part> findAll(int page, String name){
        return partdao.findAll((page-1) * 10, name);
    }
    @Override
    public void save(Part part) {
        List<Part> allParts = partdao.findAll();
        boolean dublicate = false;
        for (int i = 0; i < allParts.size(); i++){
            Part partFromList = allParts.get(i);
            if (partFromList.equals(part)){
                partFromList.setCount(part.getCount() + partFromList.getCount());
                partdao.update(partFromList);
                dublicate = true;
            }
        }
        if (!dublicate)partdao.save(part);
    }

    @Override
    public Part getById(int id) {
        return partdao.getById(id);
    }

    @Override
    public void update(Part part) {
        partdao.update(part);
    }

    @Override
    public void delete(int id) {
        partdao.delete(id);
    }

    public int collectComputers(){
        int countComputers = Integer.MAX_VALUE;
        for (Part part : partdao.findAll()){
            if (part.getRequired()==1 && part.getCount() < countComputers) countComputers = part.getCount();
        }
        if (countComputers == Integer.MAX_VALUE) countComputers = 0;
        return countComputers;
    }

    public int getPagesCount(){
        List<Part> allParts = partdao.findAll();
        int count =  allParts.size() / 10;
        if (allParts.size() % 10 != 0) count++;
        if (allParts.size() / 10 == 0) count = 1;
        return count;
    }

    public int getPagesCount(boolean required){
        int requiredInt = required ? 1 : 0;
        List<Part> allParts = partdao.findAll();
        int size = 0;
        for (Part part : allParts){
            if (part.getRequired() == requiredInt) size++;
        }
        int count = size / 10;
        if (size % 10 != 0) count++;
        if (size / 10 == 0) count = 1;
        return count;
    }

}
