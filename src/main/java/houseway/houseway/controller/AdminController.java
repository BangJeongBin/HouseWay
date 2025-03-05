package houseway.houseway.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    // 로그인
    @GetMapping("/")
    public String login() {
        return "views/admin/login";
    }


    // 로그아웃
    @GetMapping("/logout")
    public String logout() {
        return "views/admin/login";
    }


    // 비밀번호 재설정
    @GetMapping("/rePassword")
    public String rePassword() {
        return "views/admin/reset_password";
    }


    // 에러 페이지
    @GetMapping("/error")
    public String error() {
        return "views/admin/error";
    }


    // 메인 페이지
    @GetMapping("/index")
    public String index() {
        return "views/admin/index";
    }


    // 매물 리스트
    @GetMapping("/product")
    public String product() {
        return "views/admin/product";
    }


    // 매물 상세
    @GetMapping("/product_view")
    public String productView() {
        return "views/admin/product_view";
    }


    // 회원 리스트
    @GetMapping("/member")
    public String member() {
        return "views/admin/member";
    }


    // 회원 상세
    @GetMapping("/member_view")
    public String memberView() {
        return "views/admin/member_view";
    }


    // 예약 리스트
    @GetMapping("/book")
    public String book() {
        return "views/admin/book";
    }


    // 공인중개사 리스트
    @GetMapping("/agent")
    public String agent() {
        return "views/admin/agent";
    }


    // 공인중개사 상세
    @GetMapping("/agent_view")
    public String agentView() {
        return "views/admin/agent_view";
    }


    // help - 삭제보류 중
    @GetMapping("/help")
    public String help() {
        return "views/admin/help";
    }


}
