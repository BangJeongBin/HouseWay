package houseway.houseway.repository.user;

import houseway.houseway.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserRepository {
    @Insert("insert into user(userid, passwd, name, email) values(#{userid},#{passwd},#{name},#{email})")
    int insertMember(User user);

    @Select("select * from user where userid = #{userid}")
    User findByUserId(String userid);

    @Select("select count(userid) from user where userid = #{userid}")
    int countByUserid(String userid);

    @Select("select count(email) from user where email = #{email}")
    int countByEmail(String email);
}
