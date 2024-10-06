package biocueingapp.service;

import biocueingapp.model.Client;
import biocueingapp.model.EmergencyInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmergencyInfoService {

    public EmergencyInfo getEmergencyInfo(Client client) {
        return client.getEmergencyInfo();
    }

    public EmergencyInfo addEmergencyInfo(EmergencyInfo emergencyInfo) {
        return emergencyInfo;
    }

    public EmergencyInfo updateEmergencyInfo(EmergencyInfo emergencyInfo) {
        return emergencyInfo;
    }
}
