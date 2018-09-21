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
        partdao.save(part);
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
}
