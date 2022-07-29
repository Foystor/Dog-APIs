package com.udacity.DogGraphqlApi.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.udacity.DogGraphqlApi.entity.Dog;
import com.udacity.DogGraphqlApi.exception.BreedNotFoundException;
import com.udacity.DogGraphqlApi.exception.DogNotFoundException;
import com.udacity.DogGraphqlApi.repository.DogRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {
    private DogRepository dogRepository;

    public Mutation(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public boolean deleteDogBreed(String breed) {
        boolean deleted = false;
        Iterable<Dog> dogs = dogRepository.findAll();

        for (Dog dog : dogs) {
            if (dog.getBreed().matches(breed)) {
                dogRepository.delete(dog);
                deleted = true;
            }
        }

        if (!deleted) {
            throw new BreedNotFoundException("Breed Not Found", breed);
        }

        return true;
    }

    public Dog updateDogName(String newName, Long id) {
        Optional<Dog> optionalDog = dogRepository.findById(id);

        if (optionalDog.isPresent()) {
            Dog dog = optionalDog.get();
            dog.setName(newName);
            dogRepository.save(dog);
            return dog;
        } else {
            throw new DogNotFoundException("Dog Not Found", id);
        }
    }
}
