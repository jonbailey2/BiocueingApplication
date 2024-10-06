package biocueingapp.model;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmergencyInfo {
    private String emergencyContact;

    private List<String> emergencyContactInfo;
}
