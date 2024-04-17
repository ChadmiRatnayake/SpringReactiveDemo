package com.example.reactiveDemo;

import com.example.reactiveDemo.student.Student;
import com.example.reactiveDemo.student.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReactiveDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			StudentService service
	){
		return args -> {
			for (int i=0; i<100; i++){
				service.save(
						Student.builder()
								.firstName("Kiwi " + i)
								.lastName("Teddy " + i)
								.age(i)
								.build()
				).subscribe(); // student returns a mono so we have to subscribe to save all data at once
			}
		};
	}

}
