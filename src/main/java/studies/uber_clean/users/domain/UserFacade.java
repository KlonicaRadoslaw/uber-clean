package studies.uber_clean.users.domain;

import studies.uber_clean.users.dto.requests.CreateUserRequest;

import java.util.List;
//Tydzień 4, Wzorzec Facade 1
public class UserFacade {
    private final UserRepository userRepository;

    public UserFacade(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // TODO(Docelowo zwracac UserDetailedResponse lub UserSimplifiedResponse)
    public User createUser(CreateUserRequest createUserRequest, String type) {
        // TODO(Walidacja jakas tutaj i pewnie w klasie Userow)
        User user;
        //Tydzień 1, Wzorzec Factory 1
        //Wytwarzanie użytkowników za pomocą fabryki zależnie od typu
        switch (type.toLowerCase()) {
            case "customer" -> user = new Customer(createUserRequest.email, createUserRequest.password, CustomerType.STANDARD);
            case "driver" -> user = new Driver(createUserRequest.email, createUserRequest.password);
            default -> throw new IllegalArgumentException("Unknown user type: " + type);
        }
        //Koniec, Tydzień 1, Wzorzec Factory 1
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        users.forEach(user -> System.out.println(user.email));
        return users;
    }
}
//Koniec, Tydzień 4, Wzorzec Facade 1