package com.clinica.Clase14.Springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Clase14SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(Clase14SpringbootApplication.class, args);
	}

	@GetMapping("paciente")
	public String holaPAciente(){
		return "Hola Paciente";
	}

}
