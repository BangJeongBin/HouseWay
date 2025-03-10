package houseway.houseway.repository.admin;

import houseway.houseway.domain.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MemberAdminRepository {

    // 모든 회원 수
    @Select("select count(user_num) from user")
    int countMember();

    // 회원 리스트
    @Select("select user_num, user_id, user_name, user_email, user_gender, user_regdate from user order by user_num desc limit #{strnum}, #{pageSize}")
    List<UserListDTO> memberList(int strnum, int pageSize);

    // 해당 멤버 상세정보
    @Select("select * from user where user_id = #{userId}")
    User selectOneMember(String userId);

    // 해당 맴버 예약 리스트
    @Select("select * from reserv where user_id = #{userId}")
    List<Reserv> selectMemberReserv(String userId);

    // 해당 멤버 구매 내역 리스트
    @Select("select * from sales where user_id = #{userId}")
    List<Sales> selectMemberSales(String userId);

    // 해당 맴버 북마크 리스트
    @Select("select * from bookmark where user_id = #{userId}")
    List<Bookmark> selectMemberBookmark(String userId);

    // 멤버 삭제
    @Delete("delete from user where user_id = #{userId}")
    int deleteMember(String userId);
}
