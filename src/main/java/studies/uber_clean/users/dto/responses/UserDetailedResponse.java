package studies.uber_clean.users.dto.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDetailedResponse {
    public Long userId;
    public String email;
    public String phoneNumber;
    public String userType;

    public UserDetailedResponse(Long userId, String email, String phoneNumber, String userType) {
        this.userId = userId;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userType = userType;
    }
}
