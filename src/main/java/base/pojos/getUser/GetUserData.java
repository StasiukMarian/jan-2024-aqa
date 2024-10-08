package base.pojos.getUser;

import lombok.Data;

@Data
public class GetUserData {
    public Integer id;
    public String email;
    public String first_name;
    public String last_name;
    public String avatar;
}
