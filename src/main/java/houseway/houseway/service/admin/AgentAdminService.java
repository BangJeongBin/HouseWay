package houseway.houseway.service.admin;

import houseway.houseway.domain.AgentInfoDTO;
import houseway.houseway.domain.AgentPageDTO;
import houseway.houseway.domain.UserPageDTO;

public interface AgentAdminService {

    // 공인중개사 리스트(페이지네이션)
    AgentPageDTO readAgent(int cpg);

    // 정렬 공인중개사 리스트(페이지네이션)
    AgentPageDTO readSortAgent(int cpg, int sno);

    // 공인중개사 상세
    AgentInfoDTO readOneAgent(int agentNum);

    // 공인중개사 삭제
    int removeAgent(int agentNum);
}
