package biocueingapp.service;

import biocueingapp.model.Biofeedback;
import biocueingapp.model.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
public class BiofeedbackTest {

    BiofeedbackService biofeedbackService = new BiofeedbackService();

    Client client = new Client();

    Biofeedback expectedBiofeedback = new Biofeedback();

    @BeforeEach
    void setup() {
        client.setBiofeedback(expectedBiofeedback);
    }

    @Test
    void getBiofeedback() {
        assertEquals(expectedBiofeedback, biofeedbackService.getBiofeedback(client));
    }

    @Test
    void addBiofeedback() {
        Biofeedback actualBiofeedback = biofeedbackService.addBiofeedback(expectedBiofeedback);

        assertThat(expectedBiofeedback).isEqualToComparingFieldByField(actualBiofeedback);
    }

    @Test
    void updateBiofeedback() {
        assertThat(expectedBiofeedback).isEqualToComparingFieldByField(biofeedbackService.updateBiofeedback(expectedBiofeedback));
    }
}
