package biocueingapp.service.clientService;

import biocueingapp.model.Client;
import biocueingapp.model.ClientInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientInfoService {

    public ClientInfo getClientInfo(Client client) {
        return client.getClientInfo();
    }

    public ClientInfo createClientInfo(String name, String gender, List<String> contactInfo, int age) {
        return new ClientInfo(name, gender, contactInfo, age);
    }

    public Client updateClientInfo(Client client, String name, String gender, List<String> contactInfo, int age) {
        return new Client(client.getId(),
                new ClientInfo(name, gender, contactInfo, age),
                client.getDevelopmentalInfo(),
                client.getMedicalInfo(),
                client.getEmergencyInfo()
        );
    }
}
