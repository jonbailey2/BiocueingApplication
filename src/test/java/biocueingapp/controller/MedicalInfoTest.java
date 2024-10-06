package biocueingapp.controller;

import biocueingapp.model.MedicalInfo;
import biocueingapp.service.MedicalInfoService;
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

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MedicalInfoTest {

    @InjectMocks
    private MedicalInfoController medicalInfoController;

    @Mock
    private MedicalInfoService medicalInfoService;

    private MedicalInfo medicalInfo;

    private String medicalInfoJson;

    private MockMvc mockMvc;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate template;

    @BeforeEach
    void setup() throws JsonProcessingException {
        mockMvc = MockMvcBuilders.standaloneSetup(medicalInfoController).build();
        medicalInfo = new MedicalInfo(Collections.singletonList("A"), "B",
                Collections.singletonList("C"), Collections.singletonList("D"));
        medicalInfoJson = new ObjectMapper().writeValueAsString(medicalInfo);
    }

    @Test
    void createMedicalInfo() throws Exception {
        final MedicalInfo expectedMedicalInfo = new MedicalInfo(Collections.singletonList("A"), "B",
                Collections.singletonList("C"), Collections.singletonList("D"));

        final ResponseEntity<MedicalInfo> response = template.postForEntity(
                String.format("http://localhost:%d/api/createMedicalInfo", port), expectedMedicalInfo, MedicalInfo.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    void getMedicalInfo() {
        final ResponseEntity<MedicalInfo> response = template.getForEntity(
                String.format("http://localhost:%d/api/getMedicalInfo", port), MedicalInfo.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void updateMedicalInfo() throws Exception {
        when(medicalInfoService.updateMedicalInfo(medicalInfo)).thenReturn(medicalInfo);
        mockMvc.perform(put("/api/updateMedicalInfo").content(medicalInfoJson).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isAccepted());
    }

    @Test
    public void tessPostTest() {
        final ResponseEntity<String> response = template.postForEntity(
                String.format("http://localhost:%d/api/testPost", port), "MARIA", String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

}
