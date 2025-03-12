package houseway.houseway.service.admin;

import houseway.houseway.domain.Admin;
import houseway.houseway.repository.admin.AccountAdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountAdminServiceImpl implements AccountAdminService {

    private final AccountAdminRepository accountMapper;


    // 관리자 로그인
    @Override
    public Admin loginAdmin(Admin admin) {
        Admin findAdmin = accountMapper.findAdminById(admin.getAdmin_id());

        if (findAdmin == null || !findAdmin.getAdmin_password().equals(admin.getAdmin_password())) {
            throw new IllegalStateException("아이디나 비밀번호가 일치하지 않습니다.");
        }
        return findAdmin;
    }


    // 관리자 이메일 확인
    @Override
    public boolean checkPwd(String admin_password) {
        Boolean checkPwd = false;

        // 등록된 관리자의 이메일 확인
        Admin findAdminEmail = accountMapper.findAdminAccount(admin_password);

        if (findAdminEmail.getAdmin_password() == admin_password) {
            checkPwd = true;
        }
        return false;
    }
}
