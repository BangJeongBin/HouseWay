package houseway.houseway.repository.admin;

import houseway.houseway.domain.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AgentAdminRepository {

    // 모든 공인중개사 수
    @Select("select count(agent_num) from agent")
    int countAgent();

    // 공인중개사 리스트
    @Select("select agent_num, agent_name, agent_phone, agent_photo, office_name, office_address, agent_local, agent_salecount from agent order by agent_num desc limit #{strnum}, #{pageSize}")
    List<AgentListDTO> agentList(int strnum, int pageSize);

    // 정렬(local) 공인중개사 리스트
    @Select("select agent_num, agent_name, agent_phone, agent_photo, office_name, office_address, agent_local, agent_salecount from agent order by office_address limit #{strnum}, #{pageSize}")
    List<AgentListDTO> agentLocalList(int strnum, int pageSize);

    // 정렬(salsecaount) 공인중개사 리스트
    @Select("select agent_num, agent_name, agent_phone, agent_photo, office_name, office_address, agent_local, agent_salecount from agent order by agent_salecount desc limit #{strnum}, #{pageSize}")
    List<AgentListDTO> agentNameList(int strnum, int pageSize);

    // 해당 공인중개사 상세정보
    @Select("select * from agent where agent_num = #{agentNum}")
    Agent selectOneAgent(int agentNum);

    // 해당 공인중개사 예약 리스트
    @Select("select * from reserv where agent_num = #{agentNum}")
    List<Reserv> selectAgentReserv(int agentNum);

    // 해당 공인중개사 매물 리스트
    @Select("select estate_id, estate_title, estate_addr, estate_deposit, estate_rent, estate_state from estate where agent_num = #{agentNum}")
    List<Estate> selectAgentestate(int agentNum);

    // 공인중개사 삭제
    @Delete("delete from agent where agent_num = #{agentNum}")
    int deleteAgent(int agentNum);
}
