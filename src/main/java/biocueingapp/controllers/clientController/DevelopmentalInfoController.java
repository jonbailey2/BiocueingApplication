package biocueingapp.controllers.clientController;

import biocueingapp.model.Client;
import biocueingapp.model.DevelopmentalInfo;
import biocueingapp.service.clientService.DevelopmentalInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class DevelopmentalInfoController {

    private final DevelopmentalInfoService developmentalInfoService;

    @PutMapping("/createDevelopmentalInfo")
    public DevelopmentalInfo createDevelopmentalInfo(List<String> milestonesAchieved, List<String> areasForDevelopment) {
        return developmentalInfoService.createDevelopmentalInfo(milestonesAchieved, areasForDevelopment);
    }

    @GetMapping("/getDevelopmentalInfo")
    public DevelopmentalInfo getDevelopmentalInfo(Client client) {
        return developmentalInfoService.getDevelopmentalInfo(client);
    }

    @PutMapping("/updateDevelopmentalInfo")
    public Client updateDevelopmentalInfo(Client client, List<String> milestonesAchieved, List<String> areasForDevelpment) {
        return developmentalInfoService.updateDevelopmentalInfo(client, milestonesAchieved, areasForDevelpment);
    }
}
