package com.example.springbootquartz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication (exclude={DataSourceAutoConfiguration.class})
public class SpringBootQuartzApplication  {


	public static void main(String[] args) {

		SpringApplication.run(SpringBootQuartzApplication.class, args);
	}
}
