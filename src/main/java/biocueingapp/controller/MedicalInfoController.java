package biocueingapp.controller;

import biocueingapp.model.Client;
import biocueingapp.model.MedicalInfo;
import biocueingapp.service.MedicalInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MedicalInfoController {

    private final MedicalInfoService medicalInfoService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/createMedicalInfo", consumes = "application/json", produces = "application/json")
    public MedicalInfo createMedicalInfo(@RequestBody final MedicalInfo medicalInfo) {
        return medicalInfoService.addMedicalInfo(medicalInfo);
    }

    @GetMapping("/getMedicalInfo")
    public MedicalInfo getMedicalInfo(Client client) {
        return medicalInfoService.getMedicalInfo(client);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/updateMedicalInfo")
    public MedicalInfo updateMedicalInfo(@RequestBody final MedicalInfo medicalInfo) {
        return medicalInfoService.updateMedicalInfo(medicalInfo);
    }

    @PostMapping("/testPost")
    public ResponseEntity<String> test(@RequestBody String string) {
        return new ResponseEntity<String>("hey" + string, HttpStatus.CREATED);

    }

}
