package houseway.houseway.repository.admin;

import houseway.houseway.domain.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AgentRepository {

    // 모든 회원 수
    @Select("select count(user_num) from user")
    int countBoard();

    // 회원 리스트
    @Select("select user_num, user_id, user_name, user_email, user_gender, user_regdate from user order by user_num desc limit #{strnum}, #{pageSize}")
    List<UserListDTO> memberList(int strnum, int pageSize);
}
