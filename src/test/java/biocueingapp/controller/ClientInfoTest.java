package biocueingapp.controller;


import biocueingapp.model.ClientInfo;
import biocueingapp.service.ClientInfoService;
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

import java.util.Collections;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClientInfoTest {

    @InjectMocks
    private ClientInfoController clientInfoController;

    @Mock
    private ClientInfoService clientInfoService;

    private ClientInfo clientInfo;

    private String clientInfoJson;

    private MockMvc mockMvc;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate template;

    @BeforeEach
    void setup() throws JsonProcessingException {
        mockMvc = MockMvcBuilders.standaloneSetup(clientInfoController).build();
        clientInfo = new ClientInfo("Maria", "Female", Collections.singletonList("111-222-3333"), 21);
        clientInfoJson = new ObjectMapper().writeValueAsString(clientInfo);
    }

    @Test
    void createClientInfo() throws Exception {
        final ClientInfo expectedClientInfo = new ClientInfo("Maria", "Female", Collections.singletonList("111-222-3333"), 21);

        final ResponseEntity<ClientInfo> response = template.postForEntity(
                String.format("http://localhost:%d/api/createClientInfo", port), expectedClientInfo, ClientInfo.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    void getClientInfo() {
        final ResponseEntity<ClientInfo> response = template.getForEntity(
                String.format("http://localhost:%d/api/getClientInfo", port), ClientInfo.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void updateClientInfo() throws Exception {
        when(clientInfoService.updateClientInfo(clientInfo)).thenReturn(clientInfo);
        mockMvc.perform(put("/api/updateClientInfo").content(clientInfoJson).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isAccepted());
    }
}
