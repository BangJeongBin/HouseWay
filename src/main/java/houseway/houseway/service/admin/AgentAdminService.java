package houseway.houseway.service.admin;

import houseway.houseway.domain.AgentPageDTO;

public interface AgentAdminService {

    // 공인중개사 리스트(페이지네이션)
    AgentPageDTO readAgent(int cpg);

    /*// 멤버 상세
    UserInfoDTO readOneAgent(String userId);*/
}
