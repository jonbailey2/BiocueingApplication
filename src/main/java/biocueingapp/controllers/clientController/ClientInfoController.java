package biocueingapp.controllers.clientController;

import biocueingapp.model.Client;
import biocueingapp.model.ClientInfo;
import biocueingapp.service.clientService.ClientInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ClientInfoController {

    private final ClientInfoService clientInfoService;

    @PutMapping("/createClientInfo")
    public ClientInfo createClientInfo(String name, String gender, List<String> contactInfo, int age) {
        return clientInfoService.createClientInfo(name, gender, contactInfo, age);
    }

    @GetMapping("/getClientInfo")
    public ClientInfo getClientInfo(Client client) {
        return clientInfoService.getClientInfo(client);
    }

    @PutMapping("/updateClientInfo")
    public Client updateClientInfo(Client client, String name, String gender, List<String> contactInfo, int age) {
        return clientInfoService.updateClientInfo(client, name, gender, contactInfo, age);
    }
}
