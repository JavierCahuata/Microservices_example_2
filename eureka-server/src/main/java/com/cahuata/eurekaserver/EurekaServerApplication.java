package com.cahuata.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.CrossOrigin;

@EnableEurekaServer
@SpringBootApplication
@CrossOrigin(origins = { "http://localhost:4200", "*" })
public class EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
		//new SpringApplicationBuilder(EurekaServerApplication.class).run(args);
	}

}
