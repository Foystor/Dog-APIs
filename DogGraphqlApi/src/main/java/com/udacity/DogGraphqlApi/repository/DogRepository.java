package com.udacity.DogGraphqlApi.repository;

import com.udacity.DogGraphqlApi.entity.Dog;
import org.springframework.data.repository.CrudRepository;

public interface DogRepository extends CrudRepository<Dog, Long> {
}
