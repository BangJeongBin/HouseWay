package houseway.houseway.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ReservOk {
    private int reserv_num;
    private String user_name;
    private String user_phone;
    private String estate_id;
    private String agent_name;
    private LocalDateTime reserv_regdate;
}
