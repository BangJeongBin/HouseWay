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

    // body 페이지 상단이 해더에 가려 색도 안먹고 안보임 내일 바로 해결 요망

}
