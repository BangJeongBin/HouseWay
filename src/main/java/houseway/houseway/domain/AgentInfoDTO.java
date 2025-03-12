package houseway.houseway.domain;

import lombok.Data;

import java.util.List;

@Data
public class AgentInfoDTO {

    private Agent agentAllInfo;
    private List<Reserv> agentReservList;
    private List<EstateAgentListDTO> agentEstateList;

    public AgentInfoDTO(Agent agentAllInfo, List<Reserv> agentReservList, List<EstateAgentListDTO> agentEstateList) {
        this.agentAllInfo = agentAllInfo;
        this.agentReservList = agentReservList;
        this.agentEstateList = agentEstateList;
    }
}
