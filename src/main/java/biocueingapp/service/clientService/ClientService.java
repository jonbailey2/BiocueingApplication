package biocueingapp.service.clientService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import biocueingapp.model.*;

import java.util.UUID;


@Service
@RequiredArgsConstructor
public class ClientService {

    public Client createClient() {
        return new Client();
    }

    public Client createClient(UUID id, ClientInfo clientInfo, DevelopmentalInfo developmentalInfo,
                               MedicalInfo medicalInfo, EmergencyInfo emergencyInfo) {
        return new Client(id, clientInfo, developmentalInfo, medicalInfo, emergencyInfo);
    }
}
