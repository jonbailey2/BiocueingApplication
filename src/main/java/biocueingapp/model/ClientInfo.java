package biocueingapp.model;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientInfo {
    private String name;
    private String gender;
    private List<String> contactInfo;
    private int age;
}
