package biocueingapp.service.client;

import biocueingapp.model.client.Client;
import biocueingapp.model.client.ClientInfo;
import biocueingapp.model.client.DevelopmentalInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
public class DevelopmentalInfoTest {

    DevelopmentalInfoService developmentalInfoService = new DevelopmentalInfoService();

    Client client = new Client();

    DevelopmentalInfo expectedDevelopmentalInfo = new DevelopmentalInfo(Collections.singletonList("A"), Collections.singletonList("B"));

    @BeforeEach
    void setup() {
        client.setDevelopmentalInfo(expectedDevelopmentalInfo);
    }

    @Test
    void getDevelopmentalInfo() {
        assertEquals(expectedDevelopmentalInfo, developmentalInfoService.getDevelopmentalInfo(client));
    }

    @Test
    void createDevelopmentalInfo() {
        DevelopmentalInfo actualDevelopmentalInfo = developmentalInfoService.createDevelopmentalInfo(Collections.singletonList("A"), Collections.singletonList("B"));

        assertThat(expectedDevelopmentalInfo).isEqualToComparingFieldByField(actualDevelopmentalInfo);
    }

    @Test
    void updateClientInfo() {
        DevelopmentalInfo expectedDevelopmentalInfo = new DevelopmentalInfo(Collections.singletonList("C"), Collections.singletonList("D"));

        Client actualClient = developmentalInfoService.updateDevelopmentalInfo(client, Collections.singletonList("C"), Collections.singletonList("D"));

        assertThat(expectedDevelopmentalInfo).isEqualToComparingFieldByField(actualClient.getDevelopmentalInfo());
    }
}
