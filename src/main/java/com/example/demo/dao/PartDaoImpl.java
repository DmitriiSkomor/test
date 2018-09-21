package com.example.demo.dao;

import com.example.demo.entity.Part;
import com.example.demo.mapper.PartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class PartDaoImpl implements PartDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void save(Part part) {
        String sql = "INSERT INTO part (name,required,count) VALUES(?, ?, ?)"; //!!
        jdbcTemplate.update(sql,part.getName(),part.getRequired(), part.getCount());
    }

    @Override
    public Part getById(int id) {

        String sql = "SELECT * FROM part WHERE id=?";
        return jdbcTemplate.queryForObject(sql,new PartMapper(),id);
    }

    public List<Part> findAll(int page) {
        String sql = "SELECT * from part LIMIT "+page+",10";
        return jdbcTemplate.query( sql, new PartMapper() );
    }
    public List<Part> findAll(int page, boolean required){
        int sqlRequired = required ? 1 : 0;
        String sql = "SELECT * from part WHERE required=? LIMIT "+page+",10";
        return jdbcTemplate.query(sql, new PartMapper(),sqlRequired);
    }

    public List<Part> findAll(){
        String sql = "SELECT name, required, count, id from part";
        return jdbcTemplate.query(sql, new PartMapper());
    }


    public void update(Part part) {
        String sql = "UPDATE part SET  name=?, required=?, count=? WHERE id=?";
        jdbcTemplate.update(sql,part.getName(),part.getRequired(), part.getCount(), part.getId());
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM part WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Part> findAll(int page, String name) {
        String sql = "SELECT * from part WHERE name=? LIMIT "+page+",10";
        return jdbcTemplate.query(sql, new PartMapper(),name);
    }
}
