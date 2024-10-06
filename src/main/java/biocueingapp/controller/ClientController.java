package biocueingapp.controller;

import biocueingapp.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import biocueingapp.service.ClientService;

import java.util.UUID;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/createEmptyClient", consumes = "application/json", produces = "application/json")
    public Client createUser() {
        return clientService.createClient();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/createClient", consumes = "application/json", produces = "application/json")
    public Client createUser(String username, ClientInfo clientInfo, DevelopmentalInfo developmentalInfo,
                             MedicalInfo medicalInfo, EmergencyInfo emergencyInfo, Biofeedback biofeedback) {
        return clientService.addClient(UUID.randomUUID(), clientInfo, developmentalInfo, medicalInfo, emergencyInfo, biofeedback);
    }
}
