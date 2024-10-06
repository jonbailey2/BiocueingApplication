package biocueingapp.service;

import biocueingapp.model.Client;
import biocueingapp.model.ClientInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientInfoService {

    public ClientInfo getClientInfo(Client client) {
        return client.getClientInfo();
    }

    public ClientInfo addClientInfo(ClientInfo clientInfo) {
        return clientInfo;
    }

    public ClientInfo updateClientInfo(ClientInfo clientInfo) {
        return clientInfo;
    }
}
