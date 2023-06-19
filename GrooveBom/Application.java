package br.com.hc.groove.bom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	public String PORT = System.getenv("port");

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
