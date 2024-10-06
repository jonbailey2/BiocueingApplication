package biocueingapp.service;

import biocueingapp.model.Client;
import biocueingapp.model.DevelopmentalInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DevelopmentalInfoService {

    public DevelopmentalInfo getDevelopmentalInfo(Client client) {
        return client.getDevelopmentalInfo();
    }

    public DevelopmentalInfo addDevelopmentalInfo( DevelopmentalInfo developmentalInfo) {
        return developmentalInfo;
    }

    public DevelopmentalInfo updateDevelopmentalInfo(DevelopmentalInfo developmentalInfo) {
        return developmentalInfo;
    }
}
