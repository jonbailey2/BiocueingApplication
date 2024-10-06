package biocueingapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Biofeedback {
    private double heartRate;

    private double bodyTemp;

    private double perspirationLevel;
}
