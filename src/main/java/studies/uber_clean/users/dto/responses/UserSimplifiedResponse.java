package studies.uber_clean.users.dto.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSimplifiedResponse {
    public Long userId;
    public String email;

    public UserSimplifiedResponse(Long userId, String email) {
        this.userId = userId;
        this.email = email;
    }
}
