package com.example.demo.entity;

import java.util.Objects;

public class Part {
    private String name;
    private int id;
    private int required;
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getRequired() {
        return required;
    }

    public void setRequired(int required) {
        this.required = required;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Part() {
    }

    public Part(String name, int required){
        this.name = name;
        this.required = required;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Part part = (Part) o;
        return required == part.required &&
                Objects.equals(name, part.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, required);
    }
}
