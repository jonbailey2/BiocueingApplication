package biocueingapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DevelopmentalInfo {
    private List<String> milestonesAchieved;

    private List<String> areasForDevelopment;
}
