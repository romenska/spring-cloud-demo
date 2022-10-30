package romenska.olha.noteservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import romenska.olha.noteservice.controller.NoteController;


@AutoConfigureMockMvc
@SpringBootTest
class NoteServiceApplicationTests {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    NoteController noteController;

    @Test
    void contextLoads() {
        assertThat(noteController).isNotNull();
    }

    @Test
    public void shouldReturnDefaultMessage() throws Exception {

        mockMvc.perform(get("/notes/notes"))
                //.andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
                //.andExpect(jsonPath("$.note.id").value("1"));
    }

}
