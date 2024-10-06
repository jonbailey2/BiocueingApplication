package biocueingapp.controller;

import biocueingapp.model.*;
import biocueingapp.service.ClientService;
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
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClientTest {

    @InjectMocks
    private ClientController clientController;

    @Mock
    private ClientService clientService;

    private Client client;

    private Client emptyClient;

    private String clientJson;

    private String emptyClientJson;

    private MockMvc mockMvc;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate template;

    @BeforeEach
    void setup() throws JsonProcessingException {
        mockMvc = MockMvcBuilders.standaloneSetup(clientController).build();
        emptyClient = new Client();
        client = new Client(UUID.randomUUID(), new ClientInfo(), new DevelopmentalInfo(),
                new MedicalInfo(), new EmergencyInfo(), new Biofeedback());
        emptyClientJson = new ObjectMapper().writeValueAsString(emptyClient);
        clientJson = new ObjectMapper().writeValueAsString(client);
    }

    @Test
    void createEmptyClient() throws Exception {
        final ResponseEntity<Client> response = template.postForEntity(
                String.format("http://localhost:%d/api/createEmptyClient", port), emptyClient, Client.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    void createClient() throws Exception {
        final ResponseEntity<Client> response = template.postForEntity(
                String.format("http://localhost:%d/api/createClient", port), client, Client.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }
}
