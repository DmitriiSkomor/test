package com.example.demo.config;

import com.example.demo.dao.PartDao;
import com.example.demo.dao.PartDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.beans.Statement;
import java.sql.ResultSet;

@Configuration
public class SpringConfig { // cannot add context

   @Bean
    public JdbcTemplate getJdbcTemplate(){
            return new JdbcTemplate(getDataSource());

   }

@Bean
    public DataSource getDataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
       dataSource.setUrl("jdbc:mysql://localhost:3306/test");
       dataSource.setUsername("root");
       dataSource.setPassword("root");
       dataSource.setDriverClassName("com.mysql.jdbc.Driver");
       return dataSource;
    }

    @Bean
    public PartDao getPartDao(){
       return new PartDaoImpl();
    }

}
