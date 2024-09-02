package biocueingapp.service.client;

import biocueingapp.model.client.Client;
import biocueingapp.model.client.ClientInfo;
import biocueingapp.model.client.MedicalInfo;
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
    void createMedicalInfo() {
        MedicalInfo actualMedicalInfo = medicalInfoService.createMedicalInfo(Collections.singletonList("A"), "B", Collections.singletonList("C"), Collections.singletonList("D"));

        assertThat(expectedMedicalInfo).isEqualToComparingFieldByField(actualMedicalInfo);
    }

    @Test
    void updateMedicalInfo() {
        MedicalInfo expectedMedicalInfo = new MedicalInfo(Collections.singletonList("AA"), "BB", Collections.singletonList("CC"), Collections.singletonList("DD"));

        Client actualClient = medicalInfoService.updateMedicalInfo(client, Collections.singletonList("AA"), "BB", Collections.singletonList("CC"), Collections.singletonList("DD"));

        assertThat(expectedMedicalInfo).isEqualToComparingFieldByField(actualClient.getMedicalInfo());
    }
}
