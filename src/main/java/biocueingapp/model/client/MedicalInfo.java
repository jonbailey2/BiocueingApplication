package biocueingapp.model.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicalInfo {
    private List<String> diagnoses;

    private String behavioralProfile;

    private List<String> triggers;

    private List<String> relaxationMethods;
}
