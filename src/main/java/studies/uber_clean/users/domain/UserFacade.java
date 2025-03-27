package studies.uber_clean.users.domain;

import studies.uber_clean.users.dto.requests.CreateUserRequest;
import studies.uber_clean.users.dto.responses.UserDetailedResponse;
import studies.uber_clean.users.dto.responses.UserSimplifiedResponse;

import java.util.List;

public class UserFacade {
    private final UserRepository userRepository;

    public UserFacade(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDetailedResponse createUser(CreateUserRequest createUserRequest, String type) {
        User user;

        // Tydzień 1, Wzorzec Factory 1
        // Wytwarzanie użytkowników za pomocą fabryki zależnie od typu
        switch (type.toLowerCase()) {
            case "customer" -> user = new Customer(createUserRequest.email, createUserRequest.password, createUserRequest.phoneNumber, CustomerType.STANDARD);
            case "driver" -> user = new Driver(createUserRequest.email, createUserRequest.password, createUserRequest.phoneNumber, createUserRequest.licenseId);
            default -> throw new IllegalArgumentException("Unknown user type: " + type);
        }
        // Koniec, Tydzień 1, Wzorzec Factory 1
        return User.toDetailedResponse(userRepository.save(user));
    }

    public List<UserSimplifiedResponse> getAllUsers() {
        List<UserSimplifiedResponse> users = userRepository.findAll().stream().map(User::toSimplifiedResponse).toList();
        users.forEach(user -> System.out.println(user.email));
        return users;
    }

    public UserDetailedResponse getUser(Long userId) {
        return User.toDetailedResponse(userRepository.findById(userId).orElseThrow());
    }

}
