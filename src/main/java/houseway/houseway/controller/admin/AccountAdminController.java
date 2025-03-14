package houseway.houseway.controller.admin;

import houseway.houseway.domain.Admin;
import houseway.houseway.service.admin.AccountAdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        session.removeAttribute("loginAdmin");   // 세션 제거

        return "redirect:/admin/";
    }


    // 비밀번호 확인 페이지
    @GetMapping("/rePassword")
    public String rePassword() {
        return "views/admin/account/check_password";
    }


    // 관리자 이메일 확인
    @PostMapping("/rePassword")
    public String rePasswordOk(@RequestParam String admin_password, RedirectAttributes redirectAttributes) {
        String returnUrl = "redirect:/admin/rePassword";

        if (!accountAdminService.checkPwd(admin_password)) {
            return returnUrl;   // 입력한 이메일이 기존에 있는 이메일이 아닌경우
        }

        // 비밀번호 검증 성공 시, Flash Attribute에 저장
        redirectAttributes.addFlashAttribute("admin_password", admin_password);
        return "redirect:/admin/reset_admin";  // 비밀번호 재설정 페이지로 이동
    }


    // 비밀번호 재설정 페이지
    @GetMapping("/reset_admin")
    public String resetAdmin(@ModelAttribute("admin_password") String admin_password, Model m) {
        if (admin_password == null || admin_password.isEmpty()) {
            return "redirect:/admin/rePassword";  // 직접 접근 방지
        }

        m.addAttribute("admin_password", admin_password);
        return "views/admin/account/reset_password";
    }


    // 비밀번호 재설정 Ok 페이지
    @PostMapping("/resetOk_admin")
    public String resetOkAdmin(@RequestParam String admin_password, Model m, HttpSession session) {
        String returnUrl = "redirect:/admin/error?type=2";

        if (!accountAdminService.resetPwd(admin_password)) {
            return returnUrl;
        }
        session.removeAttribute("loginAdmin");   // 세션 제거
        return "redirect:/admin/";
    }
}
