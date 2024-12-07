package com.example.springboot_postgreSQL;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@SpringBootApplication
public class SpringbootPostgreSqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootPostgreSqlApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(String[] args) {
        return runner -> {
            System.out.println("Hello PostgreSQL");
            // java way to connect database
			/*
			import package
			load and register
			create connection
			create statement
			execute statement
			process result
			close

             */
			String url = "jdbc:postgresql://localhost:5432/demo";
			String userName = "postgres";
			String pass = "deep4109";
			// Class.forName("org.postgresql.Driver"); //optional
			Connection connection = DriverManager.getConnection(url,userName,pass);
            System.out.println("Connection Established");

            Statement statement = connection.createStatement();
            String sql = "select name from student where sid = 1";

            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();
            System.out.println("result :"+ resultSet.getString("name"));

            connection.close();
            System.out.println("Connection Closed");


        };
    }

}
