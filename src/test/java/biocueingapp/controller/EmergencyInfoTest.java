package biocueingapp.controller;


import biocueingapp.model.EmergencyInfo;
import biocueingapp.service.EmergencyInfoService;
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
public class EmergencyInfoTest {
    @InjectMocks
    private EmergencyInfoController emergencyInfoController;

    @Mock
    private EmergencyInfoService emergencyInfoService;

    private EmergencyInfo emergencyInfo;

    private String emergencyInfoJson;

    private MockMvc mockMvc;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate template;

    @BeforeEach
    void setup() throws JsonProcessingException {
        mockMvc = MockMvcBuilders.standaloneSetup(emergencyInfoController).build();
        emergencyInfo = new EmergencyInfo("A", Collections.singletonList("111-222-3333"));
        emergencyInfoJson = new ObjectMapper().writeValueAsString(emergencyInfo);
    }

    @Test
    void createEmergencyInfo() throws Exception {
        final EmergencyInfo expectedEmergencyInfo = new EmergencyInfo("A", Collections.singletonList("111-222-3333"));

        final ResponseEntity<EmergencyInfo> response = template.postForEntity(
                String.format("http://localhost:%d/api/createEmergencyInfo", port), expectedEmergencyInfo, EmergencyInfo.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    void getEmergencyInfo() {
        final ResponseEntity<EmergencyInfo> response = template.getForEntity(
                String.format("http://localhost:%d/api/getEmergencyInfo", port), EmergencyInfo.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void updateEmergencyInfo() throws Exception {
        when(emergencyInfoService.updateEmergencyInfo(emergencyInfo)).thenReturn(emergencyInfo);
        mockMvc.perform(put("/api/updateEmergencyInfo").content(emergencyInfoJson).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isAccepted());
    }
}
