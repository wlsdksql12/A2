package com.gdu.cast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class CastApplication {

	public static void main(String[] args) {
		SpringApplication.run(CastApplication.class, args);
	}

}
