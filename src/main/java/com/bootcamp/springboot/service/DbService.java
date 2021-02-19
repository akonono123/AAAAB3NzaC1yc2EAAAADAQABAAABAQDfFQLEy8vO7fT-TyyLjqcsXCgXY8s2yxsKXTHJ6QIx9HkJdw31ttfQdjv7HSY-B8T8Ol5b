package com.bootcamp.springboot.service;


import com.bootcamp.springboot.config.dbcon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DbService {

    @Autowired
    dbcon dbconn;




    public String getDatabaseConnection() {

        return "conn";
    }

    public dbcon getDatabaseConfig() {
        return this.dbconn;
    }
}
