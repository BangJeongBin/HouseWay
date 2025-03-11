package houseway.houseway.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Slf4j  // lombok - logging객체 자동 생성
@Controller
@RequestMapping("/user") /* 이렇게 안쓴다면 아래에서 적용하면 됨 */
@RequiredArgsConstructor
public class UserController {
    //로그인 페이지 이동
    @GetMapping("/login")
    public String login() {
        return "views/user/loginForm";
    }

    //회원가입 페이지 이동
    @GetMapping("/join")
    public String join(){
        return "views/user/joinForm";
    }

    @GetMapping("/mypage")
    public String mypage(){
        return "views/user/mypage";
    }
}
