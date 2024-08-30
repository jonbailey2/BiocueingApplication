package biocueingapp.controllers.clientController;

import biocueingapp.model.Client;
import biocueingapp.model.EmergencyInfo;
import biocueingapp.service.clientService.EmergencyInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EmergencyInfoController {

    private final EmergencyInfoService emergencyInfoService;

    @PutMapping("/createEmergencyInfo")
    public EmergencyInfo createEmergencyInfo(String emergencyContact, List<String> emergencyContactInfo) {
        return emergencyInfoService.createEmergencyInfo(emergencyContact, emergencyContactInfo);
    }

    @GetMapping("/getEmergencyInfo")
    public EmergencyInfo getEmergencyInfo(Client client) {
        return emergencyInfoService.getEmergencyInfo(client);
    }

    @PutMapping("/updateEmergencyInfo")
    public Client updateEmergencyInfo(Client client, String emergencyContact, List<String> emergencyContactInfo) {
        return emergencyInfoService.updateEmergencyInfo(client, emergencyContact, emergencyContactInfo);
    }
}
