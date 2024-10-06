package biocueingapp.service;

import biocueingapp.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@RequiredArgsConstructor
public class ClientService {

    public Client createClient() {
        return new Client();
    }

    public Client addClient(UUID id, ClientInfo clientInfo, DevelopmentalInfo developmentalInfo,
                               MedicalInfo medicalInfo, EmergencyInfo emergencyInfo, Biofeedback biofeedback) {
        return new Client(id, clientInfo, developmentalInfo, medicalInfo, emergencyInfo, biofeedback);
    }
}
