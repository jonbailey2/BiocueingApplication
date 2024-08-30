package biocueingapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    private UUID id;

    private ClientInfo clientInfo;

    private DevelopmentalInfo developmentalInfo;

    private MedicalInfo medicalInfo;

    private EmergencyInfo emergencyInfo;
}
