package org.starwars.api.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.starwars.api.CrudApplication;
import org.starwars.api.repository.StarshipRepository;

import static org.hamcrest.Matchers.hasToString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = CrudApplication.class
)
@AutoConfigureMockMvc
public class StarshipRestTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private StarshipRepository repository;

    @BeforeEach
    public void setStarDestroyerStarshipInitialCountToFive() throws Exception {
        mvc.perform(put("/starship/{name}/set-unit/{unit}", "Star Destroyer", "5")
                .contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void setUnitCount() throws Exception {
        mvc.perform(put("/starship/{name}/set-unit/{unit}", "Star Destroyer", "3").contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.unitCount", hasToString("3")));
    }

    @Test
    public void decrementUnitCount() throws Exception {
        mvc.perform(put("/starship/{name}/decrement-unit/{unit}", "Star Destroyer", "3")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.unitCount", hasToString("2")));
    }

    @Test
    public void decrementUnitCountUsingWrongName() throws Exception {
        mvc.perform(put("/starship/{name}/decrement-unit/{unit}", "Wrong Name", "3")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void decrementUnitCountToNegativeUnit() throws Exception {
        mvc.perform(put("/starship/{name}/decrement-unit/{unit}", "Star Destroyer", "6")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void incrementUnitCount() throws Exception {
        mvc.perform(put("/starship/{name}/increment-unit/{unit}", "Star Destroyer", "3")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.unitCount", hasToString("8")));
    }

    @Test
    public void incrementUnitCountUsingWrongName() throws Exception {
        mvc.perform(put("/starship/{name}/increment-unit/{unit}", "Wrong Name", "3")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void setUnitCountUsingWrongName() throws Exception {
        mvc.perform(put("/starship/{name}/set-unit/{unit}", "Wrong Name", "3")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }
}