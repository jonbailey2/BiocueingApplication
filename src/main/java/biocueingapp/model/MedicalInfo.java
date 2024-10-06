package biocueingapp.model;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicalInfo {
    private List<String> diagnoses;

    private String behavioralProfile;

    private List<String> triggers;

    private List<String> relaxationMethods;
}
