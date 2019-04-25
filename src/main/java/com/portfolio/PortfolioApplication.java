package com.portfolio;

import com.portfolio.Service.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@SpringBootApplication
public class PortfolioApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(PortfolioApplication.class, args);
    }

}
