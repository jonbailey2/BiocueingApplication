package biocueingapp.controller;

import biocueingapp.model.Client;
import biocueingapp.model.DevelopmentalInfo;
import biocueingapp.service.DevelopmentalInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class DevelopmentalInfoController {

    private final DevelopmentalInfoService developmentalInfoService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/createDevelopmentalInfo", consumes = "application/json", produces = "application/json")
    public DevelopmentalInfo createDevelopmentalInfo(DevelopmentalInfo developmentalInfo) {
        return developmentalInfoService.addDevelopmentalInfo(developmentalInfo);
    }

    @GetMapping("/getDevelopmentalInfo")
    public DevelopmentalInfo getDevelopmentalInfo(Client client) {
        return developmentalInfoService.getDevelopmentalInfo(client);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/updateDevelopmentalInfo")
    public DevelopmentalInfo updateDevelopmentalInfo(DevelopmentalInfo developmentalInfo) {
        return developmentalInfoService.updateDevelopmentalInfo(developmentalInfo);
    }
}
