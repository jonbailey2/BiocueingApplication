package biocueingapp.controller;

import biocueingapp.model.Biofeedback;
import biocueingapp.model.ClientInfo;
import biocueingapp.service.BiofeedbackService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BiofeedbackTest {

    @InjectMocks
    private BiofeedbackController biofeedbackController;

    @Mock
    private BiofeedbackService biofeedbackService;

    private Biofeedback biofeedback;

    private String biofeedbackJson;

    private MockMvc mockMvc;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate template;

    @BeforeEach
    void setup() throws JsonProcessingException {
        mockMvc = MockMvcBuilders.standaloneSetup(biofeedbackController).build();
        biofeedback = new Biofeedback(1, 1, 1);
        biofeedbackJson = new ObjectMapper().writeValueAsString(biofeedback);
    }

    @Test
    void createBiofeedback() throws Exception {
        final ResponseEntity<ClientInfo> response = template.postForEntity(
                String.format("http://localhost:%d/api/createBiofeedback", port), biofeedback, ClientInfo.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    void getBiofeedback() {
        final ResponseEntity<ClientInfo> response = template.getForEntity(
                String.format("http://localhost:%d/api/getBiofeedback", port), ClientInfo.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void updateBiofeedback() throws Exception {
        when(biofeedbackService.updateBiofeedback(biofeedback)).thenReturn(biofeedback);
        mockMvc.perform(put("/api/updateBiofeedback").content(biofeedbackJson).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isAccepted());
    }
}
