package com.shridhar.springbootwebtutorial;

import com.shridhar.springbootwebtutorial.service.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@RequiredArgsConstructor
@SpringBootApplication
public class SpringbootwebtutorialApplication implements CommandLineRunner {

	private final DataService dataService;

	@Value("${my.variable}")
	private String variable;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootwebtutorialApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		System.out.println(variable);

		System.out.println("The data is : "+ dataService.getData());
	}
}
