package houseway.houseway.repository.admin;

import houseway.houseway.domain.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AccountRepository {

    // 관리자 로그인
    @Select("select * from admin where admin_id = #{admin_id}")
    Admin findAdminById(String admin_id);
}
