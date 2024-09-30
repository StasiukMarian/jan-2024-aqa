package base.pojos.updateUser;

import base.pojos.createUser.CreateUserRequest;
import lombok.Data;


@Data
public class UpdateUserResponse extends CreateUserRequest {
    private String updatedAt;
}
