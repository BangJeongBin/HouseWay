package houseway.houseway.service.admin;

import houseway.houseway.domain.*;
import houseway.houseway.repository.admin.AgentAdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgentAdminServiceImpl implements AgentAdminService {

    private final AgentAdminRepository agentMapper;
    @Value("5") private int pageSize;


    // 공인중개사 리스트(페이지네이션)
    @Override
    public AgentPageDTO readAgent(int cpg) {
        // cpg에 따라 시작위치 값 계산
        int strnum = (cpg - 1) * pageSize;
        // 모든 회원 수
        int totalCount = agentMapper.countAgent();
        // 회원 리스트
        List<AgentListDTO> agentList = agentMapper.agentList(strnum, pageSize);

        return new AgentPageDTO(cpg, totalCount, pageSize, agentList);
    }


    // 공인중개사 상세
    @Transactional
    @Override
    public AgentInfoDTO readOneAgent(int AgentNum) {
        // 해당 공인중개사 상세정보
        Agent agentAllInfo = agentMapper.selectOneAgent(AgentNum);
        // 해당 공인중개사 예약 리스트
        List<Reserv> agentReservList = agentMapper.selectAgentReserv(AgentNum);
        // 해당 공인중개사 매물 리스트(매물 데이터 미 추가)
        List<Estate> agentEstateList = agentMapper.selectAgentestate(AgentNum);

        return new AgentInfoDTO(agentAllInfo, agentReservList, agentEstateList);
    }

    // 공인중개사 삭제
    @Override
    public int removeAgent(int agentNum) {
        return agentMapper.deleteAgent(agentNum);
    }
}
