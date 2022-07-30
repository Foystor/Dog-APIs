package com.udacity.dogs.repository;

import com.udacity.dogs.entity.Dog;
import org.springframework.data.repository.CrudRepository;

public interface DogRepository extends CrudRepository<Dog, Long> {
}
