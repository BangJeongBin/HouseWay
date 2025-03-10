package houseway.houseway.service.admin;

import houseway.houseway.domain.AgentInfoDTO;
import houseway.houseway.domain.AgentPageDTO;

public interface AgentAdminService {

    // 공인중개사 리스트(페이지네이션)
    AgentPageDTO readAgent(int cpg);

    // 공인중개사 상세
    AgentInfoDTO readOneAgent(int agentNum);
}
