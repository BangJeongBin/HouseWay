package houseway.houseway.controller.user;

import houseway.houseway.domain.MyReservDTO;
import houseway.houseway.domain.UserListDTO;
import houseway.houseway.domain.UserUpdateDTO;
import houseway.houseway.repository.user.ReservRepository;
import houseway.houseway.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/user")
public class MypageController {

    private final UserService userService;
    private final ReservRepository reservService;

    @PostMapping("/mypage/{tab}")
    public ResponseEntity<?> mypage(@PathVariable String tab, HttpSession session, Model model, @RequestBody Map<String, Object> id) {
        String userId = (String) id.get("user_id");
        switch (tab) {
            case "tab1":
                try {
                    List<MyReservDTO> rev = reservService.findMyReserv(userId);
                    log.info(rev.toString());
                    return ResponseEntity.ok(rev);
                } catch (Exception e) {
                    log.error("예약 정보 조회 중 오류 발생", e);
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("예약 정보 조회 실패");
                }
            case "tab2":
                log.info("tab2 클릭됨");
                return ResponseEntity.ok("tab2 처리됨");
            case "tab3":
                log.info("tab3 클릭됨");
                return ResponseEntity.ok("tab3 처리됨");
            case "tab4":
                log.info("tab4 클릭됨");
                return ResponseEntity.ok("tab4 처리됨");
            default:
                log.info("기본 탭 처리됨");
                return ResponseEntity.ok("기본 탭 처리됨");
        }
    }

    @PostMapping("/userInfoUpdate")
    public ResponseEntity<?> userInfoUpdate(HttpSession session, Model model, @RequestBody UserUpdateDTO update) {
        ResponseEntity<?> response = ResponseEntity.internalServerError().build();

        try{
            userService.userUpdate(update);
            response = ResponseEntity.ok().build();
        } catch (IllegalStateException e) {
            response = ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    @PostMapping("/mypage/reserv_delete/{reserv_num}")
    public ResponseEntity<?> reservDelete(HttpSession session, Model model, @PathVariable String reserv_num) {
        ResponseEntity<?> response = ResponseEntity.internalServerError().build();

        try{
            reservService.deleteReserv(reserv_num);
            response = ResponseEntity.ok().build();
        } catch (IllegalStateException e) {
            response = ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            e.printStackTrace();
        }
        return  response;
    }

}
