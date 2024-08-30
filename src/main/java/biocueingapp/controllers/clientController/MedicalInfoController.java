package biocueingapp.controllers.clientController;

import biocueingapp.model.Client;
import biocueingapp.model.MedicalInfo;
import biocueingapp.service.clientService.MedicalInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MedicalInfoController {

    private final MedicalInfoService medicalInfoService;

    @PutMapping("/createMedicalInfo")
    public MedicalInfo createMedicalInfo(List<String> diagnoses, String behavioralProfile, List<String> triggers, List<String> relaxationMethods) {
        return medicalInfoService.createMedicalInfo(diagnoses, behavioralProfile, triggers, relaxationMethods);
    }

    @GetMapping("/getMedicalInfo")
    public MedicalInfo getMedicalInfo(Client client) {
        return medicalInfoService.getMedicalInfo(client);
    }

    @PutMapping("/updateMedicalInfo")
    public Client updateMedicalInfo(Client client, List<String> diagnoses, String behavioralProfile, List<String> triggers, List<String> relaxationMethods) {
        return medicalInfoService.updateMedicalInfo(client, diagnoses, behavioralProfile, triggers, relaxationMethods);
    }
}
