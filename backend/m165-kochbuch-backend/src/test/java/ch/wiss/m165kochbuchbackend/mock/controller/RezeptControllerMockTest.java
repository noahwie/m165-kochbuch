package ch.wiss.m165kochbuchbackend.mock.controller;

import ch.wiss.m165kochbuchbackend.controller.RezeptController;
import ch.wiss.m165kochbuchbackend.service.RezeptService;
import ch.wiss.m165kochbuchbackend.repository.RezeptRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(RezeptController.class)
@AutoConfigureMockMvc
public class RezeptControllerMockTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RezeptRepository rezeptRepository;

    @MockBean
    private RezeptService rezeptService;

    @Test
    public void whenPostRequestToRezeptAndValidRezept_thenCorrectResponse() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/rezept")
                        .param("category", "Hallucinogen", "global"))
                .andExpect(status().isOk());
    }

    @Test
    public void whenPostRequestToRezeptAndInValidRezept_thenCorrectResponse() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/rezept")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}")) // empty JSON object triggers validation
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error").isNotEmpty());
    }


    @Test
    public void whenGetAllRezepte_getValidRezepte() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/rezept"))
                .andDo(res -> System.out.println(res.getResponse().getContentAsString()))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }
}
