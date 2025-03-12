package houseway.houseway.controller.admin;

import houseway.houseway.domain.Admin;
import houseway.houseway.service.admin.AccountAdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AccountAdminController {

    private final AccountAdminService accountAdminService;

    // 관리자 로그인
    @PostMapping("/login")
    public ResponseEntity<?> loginOk(Admin admin, HttpSession session) {
        ResponseEntity<?> response = ResponseEntity.internalServerError().build();

        log.info("submit된 회원정보 : {}", admin);

        try {
            // 정상적으로 처리되는 경우 상태코드 200으로 응답
            Admin loginAdmin = accountAdminService.loginAdmin(admin);
            session.setAttribute("loginAdmin", loginAdmin);
            session.setMaxInactiveInterval(6000);    // 세션 유지 : 100분

            response =  ResponseEntity.ok().build();
            System.out.println("==================" + response);
        } catch (IllegalStateException e) {
            // 비정상 처리 시 상태코드 400으로 응답 - 클라이언트 쟐못
            // 아이디나 비밀번호 잘못 입력 시
            response = ResponseEntity.badRequest().body(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            // 비정상 처리 시 상태코드 500으로 응답 - 서버 쟐못
            e.printStackTrace();
        }
        return response;
    }


    // 메인 페이지
    @GetMapping("/index")
    public String index(HttpSession session) {
        String returnUrl = "views/admin/account/login";

        if (session.getAttribute("loginAdmin") != null) {
            returnUrl = "views/admin/index";
        }
        return returnUrl;
    }


    // 로그아웃
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();   // 세션 제거

        return "redirect:/";
    }


    // 비밀번호 확인 페이지
    @GetMapping("/rePassword")
    public String rePassword() {
        return "views/admin/account/reset_password";
    }


    // 관리자 이메일 확인
    @PostMapping("/rePassword/{admin_password}")
    public String rePasswordOk(@PathVariable String admin_password) {
        String returnUrl = "redirect:/admin/rePassword";

        if (!accountAdminService.checkPwd(admin_password)) {
            return returnUrl;   // 입력한 이메일이 기존에 있는 이메일이 아닌경우
        }
        return "redirect:/admin/reset_admin?admin_password=" + admin_password;
    }


    // 비밀번호 재설정 페이지
    @GetMapping("/reset_admin")
    public String resetAdmin(@RequestParam("admin_password") String admin_password, HttpSession session) {

    }
}
