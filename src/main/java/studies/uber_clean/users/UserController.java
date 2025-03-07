package studies.uber_clean.users;

import org.springframework.web.bind.annotation.*;
import studies.uber_clean.users.domain.User;
import studies.uber_clean.users.domain.UserFacade;
import studies.uber_clean.users.dto.requests.CreateUserRequest;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserFacade userFacade;

    public UserController(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userFacade.getAllUsers();
    }

    @PostMapping
    public User addUser(
            @RequestBody CreateUserRequest payload,
            @RequestParam String type) {

        return userFacade.createUser(payload, type);
    }
}
