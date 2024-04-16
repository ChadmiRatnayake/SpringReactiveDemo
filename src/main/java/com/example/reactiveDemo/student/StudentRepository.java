package com.example.reactiveDemo.student;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

// pass the entity(model) and type of primary key as arguments
public interface StudentRepository extends ReactiveCrudRepository<Student, Integer> {

    Flux<Student> findAllByFirstNameIgnoreCase(String firstName);

}
