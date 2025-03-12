package houseway.houseway.repository.user;

import houseway.houseway.domain.AgentListDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AgentRepository {
    @Select("select * from agent where agent_num = #{agent_num}")
    AgentListDTO findByAgentNum(int agent_num);

}
