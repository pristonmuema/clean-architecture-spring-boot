package com.pristonit.cleanarchetecture;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(servers = {@Server(url = "http://localhost:8080/", description = "Default Server URL"),
                              @Server(url = "http://localhost:8080/", description = "Default Server URL")})
@SpringBootApplication
public class CleanArchitectureApplication {

	public static void main(String[] args) {
		SpringApplication.run(CleanArchitectureApplication.class, args);
	}

}
