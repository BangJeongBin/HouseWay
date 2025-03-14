package houseway.houseway.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class MyReservDTO {
    private int reserv_num;
    private String estate_id;
    private String agent_name;
    private String office_name;
    private String agent_phone;
    private LocalDateTime reserv_regdate;
    private int reserv_state;
}
