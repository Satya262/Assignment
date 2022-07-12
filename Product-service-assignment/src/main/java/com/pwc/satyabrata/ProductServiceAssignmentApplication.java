package com.pwc.satyabrata;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info= @Info(title= "product RestAPI",description = "this is RestFul api for Educational purpose"))
public class ProductServiceAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceAssignmentApplication.class, args);
	}

}

