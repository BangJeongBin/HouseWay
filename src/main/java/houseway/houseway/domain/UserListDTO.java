package houseway.houseway.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UserListDTO {
    private int user_num;
    private String user_id;
    private String user_name;
    private String user_email;
    private String user_gender;
    private LocalDateTime user_regdate;
}
