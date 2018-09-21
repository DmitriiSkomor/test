package com.example.demo.service;

import com.example.demo.entity.Part;

import java.util.List;

public interface PartService {
    List<Part> findAll(int page);
    List<Part> findAll(int page, boolean required);
    public List<Part> findAll(int page, String name);
    List<Part> findAll();
    void save(Part part);

    Part getById(int id);

    void update(Part part);

    void delete(int id);
}
