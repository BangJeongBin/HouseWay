package houseway.houseway.repository.user;

import houseway.houseway.domain.MyReservDTO;
import houseway.houseway.domain.Reserv;
import org.apache.ibatis.annotations.Delete;
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

    @Select("select * from reserv where user_id = #{user_id} order by reserv_regdate desc limit 1")
    Reserv findByUserId(String user_id);

    @Select("select r.reserv_num, r.estate_id, a.agent_name, a.office_name, a.agent_phone, r.reserv_regdate, r.reserv_state" +
            " from reserv r join agent a on r.agent_num = a.agent_num" +
            " where r.user_id = #{user_id}" +
            " order by r.reserv_regdate")
    List<MyReservDTO> findMyReserv(String user_id);

    @Delete("delete from reserv where reserv_num = #{reserv_num} ")
    int deleteReserv(String reserv_num);
}
