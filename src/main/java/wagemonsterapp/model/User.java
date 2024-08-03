package wagemonsterapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private UUID id;

    private String username;

    // private String password;

    // private String email;

    // private String phoneNumber;

    private String name;

    private LocalDate dateOfBirth;

    private List<String> companies;

    // private String status;
}
