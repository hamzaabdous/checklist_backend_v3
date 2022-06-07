package com.checklist.TA;

import com.checklist.TA.service.PictureService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class TaApplication {
	static
	PictureService storageService;
	public static void main(String[] args) {
		SpringApplication.run(TaApplication.class, args);
		storageService.init();

	}

}
