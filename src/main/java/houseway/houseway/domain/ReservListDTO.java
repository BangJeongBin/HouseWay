package houseway.houseway.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ReservListDTO {
    private int reserv_num;
    private String user_id;
    private String estate_id;
    private String agent_name;
    private int reserv_state;
}
