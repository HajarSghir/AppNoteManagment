package com.gsnotes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.gsnotes.dao.INiveauDao;

@SpringBootApplication
public class ApplicationLauncher {
	@Autowired
	private INiveauDao niveauService;
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ApplicationLauncher.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ApplicationLauncher.class, args);
	}
	
}
