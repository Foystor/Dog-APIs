package com.udacity.DogRestApi.web;

import com.udacity.DogRestApi.config.TestConfig;
import com.udacity.DogRestApi.service.DogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@WebMvcTest(DogController.class)
@Import(TestConfig.class)
public class DogControllerUnitTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    DogService dogService;

    @Test
    public void getAllDogs() throws Exception {
        mockMvc.perform(get("/dogs")
                        .with(user("admin").password("password"))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));

        verify(dogService, times(1)).retrieveDogs();
    }

    @Test
    public void getBreedById() throws Exception {
        mockMvc.perform(get("/1/breed")
                        .with(user("admin").password("password"))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(dogService, times(1)).retrieveDogBreedById(1L);
    }

    @Test
    public void getDogBreeds() throws Exception {
        mockMvc.perform(get("/dogs/breed")
                        .with(user("admin").password("password"))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));

        verify(dogService, times(1)).retrieveDogBreed();
    }

    @Test
    public void getDogNames() throws Exception {
        mockMvc.perform(get("/dogs/name")
                        .with(user("admin").password("password"))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));

        verify(dogService, times(1)).retrieveDogNames();
    }
}
