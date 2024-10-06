package biocueingapp.service;

import biocueingapp.model.Biofeedback;
import biocueingapp.model.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BiofeedbackService {

    public Biofeedback getBiofeedback(Client client) {
        return client.getBiofeedback();
    }

    public Biofeedback addBiofeedback(Biofeedback biofeedback) {
        return biofeedback;
    }

    public Biofeedback updateBiofeedback(Biofeedback biofeedback) {
        return biofeedback;
    }
}
