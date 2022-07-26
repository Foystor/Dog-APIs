package com.udacity.bootstrap.service;

import com.udacity.bootstrap.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogServiceImpl implements DogService{
    @Autowired
    DogRepository dogRepository;

    @Override
    public List<String> retrieveDogBreed() {
        return dogRepository.retrieveDogBreed();
    }

    @Override
    public List<String> retrieveDogBreedById(Long id) {
        return dogRepository.retrieveDogBreedById(id);
    }

    @Override
    public List<String> retrieveDogNames() {
        return dogRepository.retrieveDogNames();
    }
}
