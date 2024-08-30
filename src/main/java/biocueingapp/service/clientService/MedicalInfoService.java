package biocueingapp.service.clientService;

import biocueingapp.model.Client;
import biocueingapp.model.ClientInfo;
import biocueingapp.model.MedicalInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicalInfoService {

    public MedicalInfo getMedicalInfo(Client client) {
        return client.getMedicalInfo();
    }

    public MedicalInfo createMedicalInfo(List<String> diagnoses, String behavioralProfile, List<String> triggers, List<String> relaxationMethods) {
        return new MedicalInfo(diagnoses, behavioralProfile, triggers, relaxationMethods);
    }

    public Client updateMedicalInfo(Client client, List<String> diagnoses, String behavioralProfile, List<String> triggers, List<String> relaxationMethods) {
        return new Client(client.getId(),
                client.getClientInfo(),
                client.getDevelopmentalInfo(),
                new MedicalInfo(diagnoses, behavioralProfile, triggers, relaxationMethods),
                client.getEmergencyInfo()
        );
    }
}
