package org.starwars.api.tests.useCases.Starship;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.starwars.api.CrudApplication;
import org.starwars.api.repository.StarshipRepository;
import org.starwars.api.useCases.Starship.DecrementUnitByName;

import static org.hamcrest.Matchers.hasToString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = CrudApplication.class
)
@AutoConfigureMockMvc
public class DecrementUnitByNameTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private StarshipRepository repository;

    @MockBean
    private DecrementUnitByName useCase;

    @Test
    public void wrongNameReturnsNull() throws Exception {
        when(useCase.update("wrong name", 3)).thenReturn(null);
    }
}