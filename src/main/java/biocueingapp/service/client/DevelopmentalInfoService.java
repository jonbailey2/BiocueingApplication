package biocueingapp.service.client;

import biocueingapp.model.client.Client;
import biocueingapp.model.client.DevelopmentalInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DevelopmentalInfoService {

    public DevelopmentalInfo getDevelopmentalInfo(Client client) {
        return client.getDevelopmentalInfo();
    }

    public DevelopmentalInfo createDevelopmentalInfo(List<String> milestonesAchieved, List<String> areasForDevelopment) {
        return new DevelopmentalInfo(milestonesAchieved, areasForDevelopment);
    }

    public Client updateDevelopmentalInfo(Client client, List<String> milestonesAchieved, List<String> areasForDevelopment) {
        return new Client(client.getId(),
                client.getClientInfo(),
                new DevelopmentalInfo(milestonesAchieved, areasForDevelopment),
                client.getMedicalInfo(),
                client.getEmergencyInfo()
        );
    }
}
