package houseway.houseway.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class AgentListDTO {
    private int agent_num;
    private String agent_name;
    private String agent_phone;
    private String agent_photo;
    private String office_name;
    private String office_address;
    private String agent_local;
    private String agent_salecount;
}
