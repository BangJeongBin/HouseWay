package houseway.houseway.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {

    // 기본 페이지(로그인 화면)
    @GetMapping("/")
    public String login() {
        return "views/admin/account/login";
    }


    // 비밀번호 재설정
    @GetMapping("/rePassword")
    public String rePassword() {
        return "views/admin/account/reset_password";
    }


    // 에러 페이지
    @GetMapping("/error")
    public String error() {
        return "views/admin/account/error";
    }


    // 예약 리스트
    @GetMapping("/book")
    public String book() {
        return "views/admin/estate/book";
    }


    // help - 삭제보류 중
    @GetMapping("/help")
    public String help() {
        return "views/admin/other/help";
    }


    // charts - 삭제보류 중
    @GetMapping("/charts")
    public String charts() {
        return "views/admin/other/charts";
    }


    // settings - 삭제보류 중
    @GetMapping("/settings")
    public String settings() {
        return "views/admin/other/settings";
    }

}
