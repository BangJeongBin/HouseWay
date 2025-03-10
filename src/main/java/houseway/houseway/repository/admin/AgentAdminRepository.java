package houseway.houseway.repository.admin;

import houseway.houseway.domain.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AgentAdminRepository {

    // 모든 공인중개사 수
    @Select("select count(agent_num) from agent")
    int countAgent();

    // 회원 리스트
    @Select("select agent_num, agent_name, agent_phone, agent_photo, office_name, office_address, agent_local, agent_salecount from agent order by agent_num desc limit #{strnum}, #{pageSize}")
    List<AgentListDTO> agentList(int strnum, int pageSize);
}
