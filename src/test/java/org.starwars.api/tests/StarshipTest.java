package org.starwars.api.tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.starwars.api.CrudApplication;
import org.starwars.api.repository.StarshipRepository;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.hasToString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = CrudApplication.class
)
@AutoConfigureMockMvc
public class StarshipTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private StarshipRepository repository;

    @Test
    public void givenListOfCountriesThenReturnsJsonArray() throws Exception {
        mvc.perform(get("/starship").contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(36)));
    }

    @Test
    public void setUnitCount() throws Exception {
        setStarDestoyerInitialCountToFive()
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.count", hasToString("5")));
    }

    @Test
    public void decrementUnitCount() throws Exception {
        setStarDestoyerInitialCountToFive();

        mvc.perform(put("/starship/{name}/decrement-unit/{unit}", "Star Destroyer", "3")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.count", hasToString("2")));
    }

    @Test
    public void incrementUnitCount() throws Exception {
        setStarDestoyerInitialCountToFive();

        mvc.perform(put("/starship/{name}/increment-unit/{unit}", "Star Destroyer", "3")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.count", hasToString("8")));
    }

    public ResultActions setStarDestoyerInitialCountToFive() throws Exception {
        return mvc.perform(put("/starship/{name}/set-unit/{unit}", "Star Destroyer", "5")
                .contentType(MediaType.APPLICATION_JSON));
    }
}