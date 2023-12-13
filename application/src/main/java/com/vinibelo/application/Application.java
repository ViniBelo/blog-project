package com.vinibelo.application;

import com.vinibelo.configuration.GeneralConfig;
import com.vinibelo.api.subject.SubjectController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@ComponentScan(basePackageClasses = SubjectController.class)
@Import(GeneralConfig.class)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
