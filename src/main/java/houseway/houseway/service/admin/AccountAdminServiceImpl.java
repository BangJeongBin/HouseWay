package houseway.houseway.service.admin;

import houseway.houseway.domain.Admin;
import houseway.houseway.domain.AdminCheckDTO;
import houseway.houseway.domain.AdminIndexDTO;
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
        boolean checkPwd = false;

        // 등록된 관리자의 이메일 확인
        int findAdminEmail = accountMapper.findAdminAccount(admin_password);

        if (findAdminEmail > 0) {
            checkPwd = true;    // 일치하는 관리자 아이디가 존재하는 경우
        }

        return checkPwd;
    }


    // 관리자 비밀번호 변경
    @Override
    public boolean resetPwd(String admin_password) {
        // 등록된 관리자 비밀번호 변경
        if (accountMapper.changeAdminPassword(admin_password) > 0) {
            return true;
        }
        return false;
    }


    // index 페이지
    @Override
    public AdminIndexDTO adminIndex() {
        // 모든 유저의 수를 추출
        int userCount = accountMapper.userCountIndex();
        // 모든 매물의 수를 추출
        int estateCount = accountMapper.estateCountIndex();
        // 모든 공인중개사의 수를 추출
        int agentCount = accountMapper.agentCountIndex();
        // 모든 예약의 수를 추출
        int reservCount = accountMapper.reservCountIndex();
        // 모든 판매된 매물의 수를 추출
        int salesCount = accountMapper.salesCountIndex();
        // 모든 월세 매물의 수를 추출
        int estateRentCount = accountMapper.estateRentCountIndex();
        // 모든 전세 매물의 수를 추출
        int estateLongRentCount = accountMapper.estateLongRentCountIndex();

        return new AdminIndexDTO(userCount, estateCount, agentCount, reservCount, salesCount, estateRentCount, estateLongRentCount);
    }
}
