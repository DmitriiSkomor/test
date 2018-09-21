package com.example.task.config;

import com.example.task.dao.PartDao;
import com.example.task.dao.PartDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

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
