package wagemonsterapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import wagemonsterapp.model.User;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    public User createUser(UUID id, String username, String name, LocalDate dateOfBirth, List<String> companies) {
        return new User(id, username, name, dateOfBirth, companies);
    }

    public User updateUser(UUID id, String username, String name, LocalDate dateOfBirth, List<String> companies) {
        return new User(id, username, name, dateOfBirth, companies);
    }

    public void addCompany(User user, String company) {
        user.getCompanies().addLast(company);
    }

    public List<String> getCompanies(User user) {
        return user.getCompanies();
    }
}
