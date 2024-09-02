package biocueingapp.service.client;

import biocueingapp.model.client.Client;
import biocueingapp.model.client.EmergencyInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
public class EmergencyInfoTest {

    EmergencyInfoService emergencyInfoService = new EmergencyInfoService();

    Client client = new Client();

    EmergencyInfo expectedEmergencyInfo = new EmergencyInfo("Maria", Collections.singletonList("123-456-7890"));

    @BeforeEach
    void setup() {
        client.setEmergencyInfo(expectedEmergencyInfo);
    }

    @Test
    void getEmergencyInfo() {
        assertEquals(expectedEmergencyInfo, emergencyInfoService.getEmergencyInfo(client));
    }

    @Test
    void createEmergencyInfo() {
        EmergencyInfo actualEmergencyInfo = emergencyInfoService.createEmergencyInfo("Maria", Collections.singletonList("123-456-7890"));

        assertThat(expectedEmergencyInfo).isEqualToComparingFieldByField(actualEmergencyInfo);
    }

    @Test
    void updateEmergencyInfo() {
        EmergencyInfo expectedEmergencyInfo = new EmergencyInfo("Maria Young", Collections.singletonList("321-456-7890"));

        Client actualClient = emergencyInfoService.updateEmergencyInfo(client, "Maria Young", Collections.singletonList("321-456-7890"));

        assertThat(expectedEmergencyInfo).isEqualToComparingFieldByField(actualClient.getEmergencyInfo());
    }
}
