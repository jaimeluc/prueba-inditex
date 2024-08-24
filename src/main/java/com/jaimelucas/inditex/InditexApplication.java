package com.jaimelucas.inditex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.jaimelucas.inditex", "com.jaimelucas.inditex.prices.infrastructure.inputadapter.http",
		"com.jaimelucas.inditex.prices.infrastructure.outputadapter"})
public class InditexApplication {

	public static void main(String[] args) {
		SpringApplication.run(InditexApplication.class, args);
	}

}
