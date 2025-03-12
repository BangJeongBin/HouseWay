package houseway.houseway.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserInsertDTO {
    private String user_name;
    private String user_id;
    private String user_password;
    private String user_addr1;
    private String user_addr2;
    private String user_phone;
    private String user_email;
    private String user_gender;
}
