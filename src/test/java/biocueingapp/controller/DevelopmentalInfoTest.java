package biocueingapp.controller;


import biocueingapp.model.DevelopmentalInfo;
import biocueingapp.service.DevelopmentalInfoService;
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
public class DevelopmentalInfoTest {

    @InjectMocks
    private DevelopmentalInfoController developmentalInfoController;

    @Mock
    private DevelopmentalInfoService developmentalInfoService;

    private DevelopmentalInfo developmentalInfo;

    private String developmentalInfoJson;

    private MockMvc mockMvc;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate template;

    @BeforeEach
    void setup() throws JsonProcessingException {
        mockMvc = MockMvcBuilders.standaloneSetup(developmentalInfoController).build();
        developmentalInfo = new DevelopmentalInfo(Collections.singletonList("A"), Collections.singletonList("B"));
        developmentalInfoJson = new ObjectMapper().writeValueAsString(developmentalInfo);
    }

    @Test
    void createDevelopmentalInfo() throws Exception {
        final DevelopmentalInfo expectedDevelopmentalInfo = new DevelopmentalInfo(Collections.singletonList("A"), Collections.singletonList("C"));

        final ResponseEntity<DevelopmentalInfo> response = template.postForEntity(
                String.format("http://localhost:%d/api/createDevelopmentalInfo", port), expectedDevelopmentalInfo, DevelopmentalInfo.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    void getDevelopmentalInfo() {
        final ResponseEntity<DevelopmentalInfo> response = template.getForEntity(
                String.format("http://localhost:%d/api/getDevelopmentalInfo", port), DevelopmentalInfo.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void updateDevelopmentalInfo() throws Exception {
        when(developmentalInfoService.updateDevelopmentalInfo(developmentalInfo)).thenReturn(developmentalInfo);
        mockMvc.perform(put("/api/updateDevelopmentalInfo").content(developmentalInfoJson).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isAccepted());
    }
}
