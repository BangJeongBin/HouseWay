package houseway.houseway.repository.user;

import houseway.houseway.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserRepository {
    @Insert("insert into user(user_name, user_id, user_password, user_addr1, user_addr2, user_phone, user_email, user_gender, user_regdate) values(#{user_name},#{user_id},#{user_password},#{user_addr1},#{user_addr2},#{user_phone},#{user_email},#{user_gender},sysdate")
    int insertUser(User user);

    @Select("select * from user where user_id = #{user_id")
    User findByUserId(String userid);

    @Select("select count(user_id) from user where user_id = #{user_id}")
    int countByUserid(String userid);

    @Select("select count(user_email) from user where user_email = #{user_email}")
    int countByEmail(String email);
}
