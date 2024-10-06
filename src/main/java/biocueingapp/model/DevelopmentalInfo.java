package biocueingapp.model;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DevelopmentalInfo {
    private List<String> milestonesAchieved;

    private List<String> areasForDevelopment;
}
