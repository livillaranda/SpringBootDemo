package com.revature.SpringBootDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@EntityScan("com.revature.SpringBootDemo.models")
@EnableTransactionManagement
@EnableJpaRepositories("com.revature.SpringBootDemo.repos")
@EnableJpaAuditing
@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {

		/*
		Because this is a Spring Boot Application, the @ComponentScan is not needed to scan all the
		packages. The only thing that requires designation are the JPA repositories.
		 */
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}

}
