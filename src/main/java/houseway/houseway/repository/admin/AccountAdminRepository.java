package houseway.houseway.repository.admin;

import houseway.houseway.domain.Admin;
import houseway.houseway.domain.AdminCheckDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
}
