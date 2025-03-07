package studies.uber_clean.users.domain;

import studies.uber_clean.users.dto.requests.CreateUserRequest;

import java.util.List;

public class UserFacade {
    private final UserRepository userRepository;

    public UserFacade(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // TODO(Docelowo zwracac UserDetailedResponse lub UserSimplifiedResponse)
    public User createUser(CreateUserRequest createUserRequest, String type) {
        // TODO(Walidacja jakas tutaj i pewnie w klasie Userow)
        User user;

        switch (type.toLowerCase()) {
            case "customer" -> user = new Customer(createUserRequest.email, createUserRequest.password, CustomerType.STANDARD);
            case "driver" -> user = new Driver(createUserRequest.email, createUserRequest.password);
            default -> throw new IllegalArgumentException("Unknown user type: " + type);
        }

        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        users.forEach(user -> System.out.println(user.email));
        return users;
    }
}
