package houseway.houseway.repository.admin;

import houseway.houseway.domain.Admin;
import houseway.houseway.domain.AdminCheckDTO;
import houseway.houseway.domain.EstateViewCountRankDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface AccountAdminRepository {

    // 관리자 로그인
    @Select("select * from admin where admin_id = #{admin_id}")
    Admin findAdminById(String admin_id);

    // 등록된 관리자의 이메일 확인
    @Select("select count(admin_id) from admin where admin_password = #{admin_password}")
    int findAdminAccount(String admin_password);

    // 등록된 관리자 비밀번호 변경
    @Update("update admin set admin_password = #{admin_password}")
    int changeAdminPassword(String admin_password);

    // 모든 유저의 수를 추출
    @Select("select count(user_num) from user")
    int userCountIndex();

    // 모든 매물의 수를 추출
    @Select("select count(estate_id) from estate")
    int estateCountIndex();

    // 모든 공인중개사의 수를 추출
    @Select("select count(agent_num) from agent")
    int agentCountIndex();

    // 모든 예약의 수를 추출
    @Select("select count(reserv_num) from reserv")
    int reservCountIndex();

    // 모든 판매된 매물의 수를 추출
    @Select("select count(sales_num) from sales")
    int salesCountIndex();

    // 모든 월세 매물의 수를 추출
    @Select("select COUNT(estate_id) from estate where estate_type like CONCAT('%', '월세', '%')")
    int estateRentCountIndex();

    // 모든 전세 매물의 수를 추출
    @Select("select COUNT(estate_id) from estate where estate_type like CONCAT('%', '전세', '%')")
    int estateLongRentCountIndex();

    // 등록된 매물의 조회수 랭킹을 추출(5개)
    @Select("select estate_id, estate_title, estate_viewCount from estate order by estate_viewCount desc limit 5")
    List<EstateViewCountRankDTO> estateViewRank();
}
