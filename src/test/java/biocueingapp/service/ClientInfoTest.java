package biocueingapp.service;

import biocueingapp.model.Client;
import biocueingapp.model.ClientInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
public class ClientInfoTest {

    ClientInfoService clientInfoService = new ClientInfoService();

    Client client = new Client();

    ClientInfo expectedClientInfo = new ClientInfo("Jon", "Male", Collections.singletonList("123-456-7890"), 22);

    @BeforeEach
    void setup() {
        client.setClientInfo(expectedClientInfo);
    }

    @Test
    void getClientInfo() {
        assertEquals(expectedClientInfo, clientInfoService.getClientInfo(client));
    }

    @Test
    void addClientInfo() {
        ClientInfo actualClientInfo = clientInfoService.addClientInfo(expectedClientInfo);

        assertThat(expectedClientInfo).isEqualToComparingFieldByField(actualClientInfo);
    }

    @Test
    void updateClientInfo() {
        assertThat(expectedClientInfo).isEqualToComparingFieldByField(clientInfoService.updateClientInfo(expectedClientInfo));
    }
}
