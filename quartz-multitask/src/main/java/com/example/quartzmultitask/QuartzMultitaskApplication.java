package com.example.quartzmultitask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication (exclude={DataSourceAutoConfiguration.class})
public class QuartzMultitaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuartzMultitaskApplication.class, args);
	}
}
