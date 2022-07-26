package com.udacity.bootstrap.service;

import java.util.List;

public interface DogService {
    List<String> retrieveDogBreed();
    List<String> retrieveDogBreedById(Long id);
    List<String> retrieveDogNames();
}
