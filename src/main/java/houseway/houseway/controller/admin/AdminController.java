package houseway.houseway.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {

    // 로그인
    @GetMapping("/")
    public String login() {
        return "views/admin/account/login";
    }


    // 로그아웃
    @GetMapping("/logout")
    public String logout() {
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


    // 메인 페이지
    @GetMapping("/index")
    public String index(HttpSession session) {
        String returnUrl = "views/admin/account/login";

        if (session.getAttribute("loginAdmin") != null) {
            returnUrl = "views/admin/index";
        }
        return returnUrl;
    }


    // 매물 리스트
    @GetMapping("/product")
    public String product() {
        return "views/admin/estate/product";
    }


    // 매물 상세
    @GetMapping("/product_view")
    public String productView() {
        return "views/admin/estate/product_view";
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
