package houseway.houseway.repository.user;

import houseway.houseway.domain.AgentDetailDTO;
import houseway.houseway.domain.Estate;
import houseway.houseway.domain.EstateSearchListDTO;
import houseway.houseway.domain.Reserv;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface ReservRepository {

    @Insert("insert into reserv (user_id, estate_id,agent_num,agent_name,reserv_regdate) values (#{user_id},#{estate_id}, #{agent_num},#{agent_name},#{reserv_regdate})")
    int saveReservation(String user_id, String estate_id, int agent_num, String agent_name, LocalDateTime reserv_regdate);


}
