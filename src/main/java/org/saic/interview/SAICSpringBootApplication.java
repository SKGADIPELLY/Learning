package org.saic.interview;

import org.saic.interview.domain.EmployeeDomain;
import org.saic.interview.modal.EmployeeModal;
import org.saic.interview.repositories.EmployeeIRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;
import java.util.List;

@EnableAutoConfiguration
@EnableJpaRepositories
@ComponentScan(basePackages = "org.saic.interview")
@SpringBootApplication
public class SAICSpringBootApplication{
    private static final Logger log = LoggerFactory.getLogger(SAICSpringBootApplication.class);
    public static void main(String args[]){
            SpringApplication.run(SAICSpringBootApplication.class, args);
    }
    @Autowired
    EmployeeIRepository employeeIRepository;
    @Bean
    public CommandLineRunner startup() {

        return args -> {

            List<EmployeeModal> modals = new ArrayList<>();
            List<EmployeeDomain> employeeDomains= employeeIRepository.findAll();
            for(EmployeeDomain domain : employeeDomains){
                //System.out.println("Hello");
            };
            System.out.println("Database initialized!");
        };
    }
}
