package studies.uber_clean.users.dto.requests;

import lombok.Getter;

@Getter
public class CreateUserRequest {
    public String email;
    public String password;
    public String phoneNumber;
    public String licenseId;
}
