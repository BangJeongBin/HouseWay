package houseway.houseway.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AgentDetailDTO {
    private int agent_num;
    private String agent_name;
    private String agent_phone;
    private String office_name;
    private String office_address;
    private String agent_local;
    private String agent_intro;

}
