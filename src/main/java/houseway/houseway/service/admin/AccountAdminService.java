package houseway.houseway.service.admin;

import houseway.houseway.domain.Admin;

public interface AccountAdminService {

    // 관리자 로그인
    Admin loginAdmin(Admin admin);

    // 관리자 이메일 확인
    boolean checkPwd(String admin_password);

    // 관리자 비밀번호 변경
    boolean resetPwd(String admin_password);
}
