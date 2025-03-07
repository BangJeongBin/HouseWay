package houseway.houseway.service.admin;

import houseway.houseway.domain.Admin;
import houseway.houseway.repository.admin.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountMapper;


    // 관리자 로그인
    @Override
    public Admin loginAdmin(Admin admin) {
        Admin findAdmin = accountMapper.findAdminById(admin.getAdmin_id());

        if (findAdmin == null || !findAdmin.getAdmin_password().equals(admin.getAdmin_password())) {
            throw new IllegalStateException("아이디나 비밀번호가 일치하지 않습니다.");
        }
        return findAdmin;
    }
}
