package dev.fernando.spring_pro_ch01;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringProCh01Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringProCh01Application.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(Program program) {
		return args -> {
			program.run();
		};
	}

}
