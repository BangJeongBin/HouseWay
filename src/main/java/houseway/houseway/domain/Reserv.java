package houseway.houseway.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Reserv {
    private int reserv_num;
    private String user_id;
    private String estate_id;
    private int agent_num;
    private int reserv_state;
    private LocalDateTime reserv_regdate;
}
