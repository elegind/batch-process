package com.jimmy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.jimmy.batch")
public class ReferenceTableBatchApplication {

	public static void main(String[] args) {
		System.out.println("start app");
		System.exit(SpringApplication.exit(SpringApplication.run(ReferenceTableBatchApplication.class, args)));
	}

}
