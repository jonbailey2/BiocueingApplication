package biocueingapp.controller;

import biocueingapp.model.Client;
import biocueingapp.model.EmergencyInfo;
import biocueingapp.service.EmergencyInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EmergencyInfoController {

    private final EmergencyInfoService emergencyInfoService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/createEmergencyInfo", consumes = "application/json", produces = "application/json")
    public EmergencyInfo createEmergencyInfo(EmergencyInfo emergencyInfo) {
        return emergencyInfoService.addEmergencyInfo(emergencyInfo);
    }

    @GetMapping("/getEmergencyInfo")
    public EmergencyInfo getEmergencyInfo(Client client) {
        return emergencyInfoService.getEmergencyInfo(client);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/updateEmergencyInfo")
    public EmergencyInfo updateEmergencyInfo(EmergencyInfo emergencyInfo) {
        return emergencyInfoService.updateEmergencyInfo(emergencyInfo);
    }
}
