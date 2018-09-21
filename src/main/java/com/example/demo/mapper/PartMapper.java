package com.example.demo.mapper;

import com.example.demo.entity.Part;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PartMapper implements RowMapper<Part> {

    public Part mapRow(ResultSet resultSet, int i) throws SQLException {
        Part part = new Part();
        part.setName(resultSet.getString("name"));
        part.setRequired(resultSet.getInt("required"));
        part.setCount(resultSet.getInt("count"));
        part.setId(resultSet.getInt("id"));
        return part;
    }

}
