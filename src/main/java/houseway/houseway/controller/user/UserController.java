package houseway.houseway.controller.user;

import houseway.houseway.domain.*;
import houseway.houseway.service.user.UserService;
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

    @PostMapping("/join")
    public ResponseEntity<?> joinok(UserInsertDTO user) {
        ResponseEntity<?> response = ResponseEntity.internalServerError().build();

        try{
            userService.userJoin(user);
            response = ResponseEntity.ok().build();
        }catch(IllegalStateException e){
            response = ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginok(UserInsertDTO user, HttpSession session) {
        ResponseEntity<?> response = ResponseEntity.internalServerError().build();

        log.info("submit 정보 : {}", user);

        try{
            // 정상 처리시 상태코드 200으로 응답
            UserInsertDTO loginUser = userService.loginUser(user);
            session.setAttribute("loginUser", loginUser);
            session.setMaxInactiveInterval(600); // 세션 유지 10분

            response = ResponseEntity.ok().build();
        }catch(IllegalStateException e){
            response = ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
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
    public String reservationPage() {
        return "views/user/reservation";
    }

    @GetMapping("/index_demo")
    public String indexDemo() {

        return "views/user/index_demo";
    }

}
