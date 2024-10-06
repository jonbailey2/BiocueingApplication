package biocueingapp.service;

import biocueingapp.model.Client;
import biocueingapp.model.MedicalInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MedicalInfoService {

    public MedicalInfo getMedicalInfo(Client client) {
        return client.getMedicalInfo();
    }

    public MedicalInfo addMedicalInfo(MedicalInfo medicalInfo) {
        return medicalInfo;
    }

    public MedicalInfo updateMedicalInfo(MedicalInfo medicalInfo) {
        return medicalInfo;
    }
}
