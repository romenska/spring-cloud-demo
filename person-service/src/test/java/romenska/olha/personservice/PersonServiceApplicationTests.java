package romenska.olha.personservice;


import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import romenska.olha.personservice.controller.PersonController;

@AutoConfigureMockMvc
@SpringBootTest
@Sql(value = "/create_persons.sql",executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/delete_persons.sql",executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)

class PersonServiceApplicationTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PersonController personController;

    @Test
    void contextLoads() throws Exception {
        assertThat(personController).isNotNull();

        mockMvc.perform(get("/user/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Андрій"))
                .andExpect(jsonPath("$.lastName").value("Роменський"));

    }
}
