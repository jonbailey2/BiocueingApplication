package biocueingapp.controller;

import biocueingapp.model.Client;
import biocueingapp.model.ClientInfo;
import biocueingapp.service.ClientInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ClientInfoController {

    private final ClientInfoService clientInfoService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/createClientInfo", consumes = "application/json", produces = "application/json")
    public ClientInfo createClientInfo(ClientInfo clientInfo) {
        return clientInfoService.addClientInfo(clientInfo);
    }

    @GetMapping("/getClientInfo")
    public ClientInfo getClientInfo(Client client) {
        return clientInfoService.getClientInfo(client);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/updateClientInfo")
    public ClientInfo updateClientInfo(ClientInfo clientInfo) {
        return clientInfoService.updateClientInfo(clientInfo);
    }
}
