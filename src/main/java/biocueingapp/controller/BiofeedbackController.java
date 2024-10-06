package biocueingapp.controller;

import biocueingapp.model.Biofeedback;
import biocueingapp.model.Client;
import biocueingapp.service.BiofeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BiofeedbackController {

    private final BiofeedbackService biofeedbackService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/createBiofeedback", consumes = "application/json", produces = "application/json")
    public Biofeedback createBiofeedback(@RequestBody final Biofeedback biofeedback) {
        return biofeedbackService.addBiofeedback(biofeedback);
    }

    @GetMapping("/getBiofeedback")
    public Biofeedback getBiofeedback(Client client) {
        return biofeedbackService.getBiofeedback(client);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/updateBiofeedback")
    public Biofeedback updateBiofeedback(@RequestBody final Biofeedback biofeedback) {
        return biofeedbackService.updateBiofeedback(biofeedback);
    }
}
