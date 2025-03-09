package studies.uber_clean.users;

import org.springframework.web.bind.annotation.*;
import studies.uber_clean.users.domain.UserFacade;
import studies.uber_clean.users.dto.requests.CreateUserRequest;
import studies.uber_clean.users.dto.responses.UserDetailedResponse;
import studies.uber_clean.users.dto.responses.UserSimplifiedResponse;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserFacade userFacade;

    public UserController(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    @GetMapping
    public List<UserSimplifiedResponse> getAllUsers() {
        return userFacade.getAllUsers();
    }

    @GetMapping("/{userId}")
    public UserDetailedResponse getUser(@PathVariable Long userId) {
        return userFacade.getUser(userId);
    }

    @PostMapping
    public UserDetailedResponse addUser(
            @RequestBody CreateUserRequest payload,
            @RequestParam String type) {

        return userFacade.createUser(payload, type);
    }
}
