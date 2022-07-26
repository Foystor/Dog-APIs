package com.udacity.bootstrap.web;

import com.udacity.bootstrap.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class DogController {
    private DogService dogService;

    @Autowired
    public void setDogService(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping("/breed")
    public ResponseEntity<List<String>> getDogBreed() {
        List<String> list = dogService.retrieveDogBreed();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping({"/breedById/{id}", "/breedById"})
    public ResponseEntity<List<String>> getDogBreedById(@PathVariable(required = false) Long id) {
        if (id == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        List<String> list = dogService.retrieveDogBreedById(id);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/name")
    public ResponseEntity<List<String>> getDogNames() {
        List<String> list = dogService.retrieveDogNames();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
