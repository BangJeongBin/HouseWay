package houseway.houseway.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class User {
    private int user_num;
    private String user_name;
    private String user_id;
    private String user_password;
    private String user_addr1;
    private String user_addr2;
    private String user_phone;
    private String user_email;
    private String user_gender;
    private LocalDateTime user_regdate;
}
