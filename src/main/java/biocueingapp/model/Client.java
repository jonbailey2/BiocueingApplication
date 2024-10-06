package biocueingapp.model;

import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    private UUID id;

    private ClientInfo clientInfo;

    private DevelopmentalInfo developmentalInfo;

    private MedicalInfo medicalInfo;

    private EmergencyInfo emergencyInfo;

    private Biofeedback biofeedback;
}
