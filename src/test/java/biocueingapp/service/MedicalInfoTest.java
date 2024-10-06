package biocueingapp.service;

import biocueingapp.model.Client;
import biocueingapp.model.MedicalInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
public class MedicalInfoTest {

    MedicalInfoService medicalInfoService = new MedicalInfoService();

    Client client = new Client();

    MedicalInfo expectedMedicalInfo = new MedicalInfo(Collections.singletonList("A"), "B", Collections.singletonList("C"), Collections.singletonList("D"));

    @BeforeEach
    void setup() {
        client.setMedicalInfo(expectedMedicalInfo);
    }

    @Test
    void getMedicalInfo() {
        assertEquals(expectedMedicalInfo, medicalInfoService.getMedicalInfo(client));
    }

    @Test
    void addMedicalInfo() {
        MedicalInfo actualMedicalInfo = medicalInfoService.addMedicalInfo(expectedMedicalInfo);

        assertThat(expectedMedicalInfo).isEqualToComparingFieldByField(actualMedicalInfo);
    }

    @Test
    void updateMedicalInfo() {
        assertEquals(expectedMedicalInfo, medicalInfoService.updateMedicalInfo(medicalInfoService.updateMedicalInfo(expectedMedicalInfo)));
    }
}
