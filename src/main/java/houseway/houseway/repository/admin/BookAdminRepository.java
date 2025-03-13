package houseway.houseway.repository.admin;

import houseway.houseway.domain.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface BookAdminRepository {

    // 모든 예약 수
    @Select("select count(reserv_num) from reserv")
    int countReserv();
    // 모든 예약 리스트
    @Select("select reserv_num, user_id, estate_id, agent_name, reserv_state from reserv order by reserv_num desc limit #{strnum}, #{pageSize}")
    List<ReservListDTO> reservList(int strnum, int pageSize);

    // 성공 예약 수
    @Select("select count(reserv_num) from reserv")
    int countReservSuccess();
    // 성공 예약 리스트
    @Select("select reserv_num, user_id, estate_id, agent_name, reserv_state from reserv where reserv_state = 3 order by reserv_num desc limit #{strnum}, #{pageSize}")
    List<ReservListDTO> reservListSuccess(int strnum, int pageSize);

    // 대기 예약 수
    @Select("select count(reserv_num) from reserv")
    int countReservPending();
    // 대기 예약 리스트
    @Select("select reserv_num, user_id, estate_id, agent_name, reserv_state from reserv where reserv_state = 1 order by reserv_num desc limit #{strnum}, #{pageSize}")
    List<ReservListDTO> reservListPending(int strnum, int pageSize);

    // 반려 예약 수
    @Select("select count(reserv_num) from reserv")
    int countReservCancelled();
    // 반려 예약 리스트
    @Select("select reserv_num, user_id, estate_id, agent_name, reserv_state from reserv where reserv_state = 2 order by reserv_num desc limit #{strnum}, #{pageSize}")
    List<ReservListDTO> reservListCancelled(int strnum, int pageSize);


    // 예약 승인
    @Update("update reserv set reserv_state = 3 where reserv_num = #{reserv_num}")
    int reservStateOk(int reservNum);

    // 예약 반려
    @Update("update reserv set reserv_state = 2 where reserv_num = #{reserv_num}")
    int reservStateNo(int reservNum);
}
