package biocueingapp.controllers.clientController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import biocueingapp.model.*;
import biocueingapp.service.clientService.ClientService;

import java.util.UUID;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PutMapping("/createEmptyClient")
    public Client createUser() {
        return clientService.createClient();
    }

    @PutMapping("/createClient")
    public Client createUser(String username, ClientInfo clientInfo, DevelopmentalInfo developmentalInfo,
                             MedicalInfo medicalInfo, EmergencyInfo emergencyInfo) {
        return clientService.createClient(UUID.randomUUID(), clientInfo, developmentalInfo, medicalInfo, emergencyInfo);
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
