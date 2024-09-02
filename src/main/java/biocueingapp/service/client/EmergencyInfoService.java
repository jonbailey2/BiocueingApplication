package biocueingapp.service.client;

import biocueingapp.model.client.Client;
import biocueingapp.model.client.EmergencyInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmergencyInfoService {

    public EmergencyInfo getEmergencyInfo(Client client) {
        return client.getEmergencyInfo();
    }

    public EmergencyInfo createEmergencyInfo(String emergencyContact, List<String> emergencyContactInfo) {
        return new EmergencyInfo(emergencyContact, emergencyContactInfo);
    }

    public Client updateEmergencyInfo(Client client, String emergencyContact, List<String> emergencyContactInfo) {
        return new Client(client.getId(),
                client.getClientInfo(),
                client.getDevelopmentalInfo(),
                client.getMedicalInfo(),
                new EmergencyInfo(emergencyContact, emergencyContactInfo)
        );
    }
}
