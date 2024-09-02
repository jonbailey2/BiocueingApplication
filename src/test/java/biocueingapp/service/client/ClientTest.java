package biocueingapp.service.client;

import biocueingapp.model.client.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
public class ClientTest {

    ClientService clientService = new ClientService();

    Client expectedEmptyClient = new Client();

    Client expectedClient = new Client(UUID.randomUUID(),
            new ClientInfo(), new DevelopmentalInfo(), new MedicalInfo(), new EmergencyInfo());

    @Test
    void createEmptyClient() {
        assertThat(expectedEmptyClient).isEqualToComparingFieldByField(clientService.createClient());
    }

    @Test
    void createClient() {
        Client actualClient = clientService.createClient(expectedClient.getId(),
                new ClientInfo(), new DevelopmentalInfo(), new MedicalInfo(), new EmergencyInfo());

        assertEquals(expectedClient.getId(), actualClient.getId());
        assertThat(expectedClient.getClientInfo()).isEqualToComparingFieldByField(actualClient.getClientInfo());
        assertThat(expectedClient.getDevelopmentalInfo()).isEqualToComparingFieldByField(actualClient.getDevelopmentalInfo());
        assertThat(expectedClient.getMedicalInfo()).isEqualToComparingFieldByField(actualClient.getMedicalInfo());
        assertThat(expectedClient.getEmergencyInfo()).isEqualToComparingFieldByField(actualClient.getEmergencyInfo());

    }
}
