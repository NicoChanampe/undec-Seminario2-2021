package com.undec.pandulce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/abuelaNicolasa")
public class PandulceBackendClasesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PandulceBackendClasesApplication.class, args);
	}

	@GetMapping("/saludo")
	public String saludo(){
		return "Hola sea usted muy bienvenido";
	}
}
