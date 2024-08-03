package wagemonsterapp.controllers;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wagemonsterapp.model.User;
import wagemonsterapp.service.UserService;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/createUser")
    public User createUser(UUID id, String username, String name, LocalDate dateOfBirth, List<String> companies) {
        return userService.createUser(id, username, name, dateOfBirth, companies);
    }

    @GetMapping("/updateUser")
    public User updateUser(UUID id, String username, String name, LocalDate dateOfBirth, List<String> companies) {
        return userService.updateUser(id, username, name, dateOfBirth, companies);
    }

    @PostMapping("/addCompany")
    public void addCompany(User user, String company) {
        userService.addCompany(user, company);
    }

    @GetMapping("/getCompanies")
    public List<String> getCompanies(User user) {
        return userService.getCompanies(user);
    }

    public static void main(String[] args) {
        UserController userController = new UserController(new UserService());
        User user = new User();

        userController.addCompany(user, "Outback");
        System.out.println(userController.getCompanies(user));
    }
}
