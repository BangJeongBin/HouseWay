package houseway.houseway.repository.user;

import houseway.houseway.domain.MyReservDTO;
import houseway.houseway.domain.Reserv;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ReservRepository {

    @Select("select r.estate_id, a.agent_name, a.office_name, a.agent_phone, r.reserv_regdate, r.reserv_state" +
            " from reserv r join agent a on r.agent_num = a.agent_num" +
            " where r.user_id = #{user_id}" +
            " order by r.reserv_regdate")
    List<MyReservDTO> findMyReserv(String user_id);
}
