package com.udacity.DogRestApi.repository;

import com.udacity.DogRestApi.entity.Dog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DogRepository extends CrudRepository<Dog, Long> {
    @Query(value = "SELECT s.id, s.breed FROM DOG s", nativeQuery = true)
    List<String> findAllBreed();

    @Query(value = "SELECT s.id, s.breed FROM DOG s WHERE s.id=:id", nativeQuery = true)
    String findBreedById(Long id);

    @Query(value = "SELECT s.id, s.name FROM DOG s", nativeQuery = true)
    List<String> findAllName();
}
