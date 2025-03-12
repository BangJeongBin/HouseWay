package houseway.houseway.service.user;

import houseway.houseway.domain.Agent;
import houseway.houseway.domain.AgentListDTO;
import houseway.houseway.repository.user.AgentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AgentService {
    private final AgentRepository agentMapper;

    public AgentListDTO loginAgent(AgentListDTO agent) {

        AgentListDTO findAgent = agentMapper.findByAgentNum(agent.getAgent_num());

        if(findAgent == null || !findAgent.getAgent_name().equals(agent.getAgent_name())) {
            throw new IllegalStateException("공인중개사 번호와 이름이 일치하지 않습니다. 다시 입력해주세요");
        }
        return findAgent;
    }
}
