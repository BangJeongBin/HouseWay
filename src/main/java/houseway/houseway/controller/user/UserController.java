package houseway.houseway.controller.user;

import houseway.houseway.domain.User;
import houseway.houseway.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j  // lombok - logging객체 자동 생성
@Controller
@RequestMapping("/user") /* 이렇게 안쓴다면 아래에서 적용하면 됨 */
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

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

    // ResponseEntity 는 스프링에서 HTTP와 관련된 기능을 구현할 때 사용.
    // 상태코드, HTTP 헤더, HTTP 본문 등을 명시적으로 설정 가능
    @PostMapping("/join")
    public ResponseEntity<?> joinok(User user) {
        // 회원 가입 처리시 기타 오류 발생에 대한 응답코드 설정
        ResponseEntity<?> response = ResponseEntity.internalServerError().build();

        try{
            // 정상 처리시 상태코드 200으로 응답
            userService.userJoin(user);
            response = ResponseEntity.ok().build();
        }catch(IllegalStateException e){
            // 비 정상 처리시 상태코드 400으로 응답 - 클라이언트 잘못
            // 중복 아이디나 중복 이메일 사용시
            response = ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            // 비정상 처리시 상태코드 500으로 응답 - 서버 잘못
            e.printStackTrace();
        }
        return response;
    }

    //------------------------------

    @GetMapping("/search")
    public String find() {

        return "views/user/search";
    }

    @GetMapping("/estateDetail")
    public String estateDetail() {

        return "views/user/estateDetail";
    }

    @GetMapping("/reservation")
    public String reservOk() {

        return "views/user/reservation";
    }

    @GetMapping("/index_demo")
    public String indexDemo() {

        return "views/user/index_demo";
    }

}
