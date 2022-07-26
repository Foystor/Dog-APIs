package com.udacity.bootstrap.repository;

import com.udacity.bootstrap.entity.Dog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DogRepository extends CrudRepository<Dog, Long> {
    @Query(value = "SELECT s.breed FROM DOG s", nativeQuery = true)
    List<String> retrieveDogBreed();

    @Query(value = "SELECT s.breed FROM DOG s WHERE s.id = :id", nativeQuery = true)
    List<String> retrieveDogBreedById(@Param("id") Long id);

    @Query(value = "SELECT s.name FROM DOG s", nativeQuery = true)
    List<String> retrieveDogNames();
}
