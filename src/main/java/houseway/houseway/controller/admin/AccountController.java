package houseway.houseway.controller.admin;

import houseway.houseway.domain.Admin;
import houseway.houseway.repository.admin.AccountRepository;
import houseway.houseway.service.admin.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/account")
public class AccountController {

    @PostMapping("/login")
    public ResponseEntity<?> loginOk(Admin admin, HttpSession session) {
        ResponseEntity<?> response = ResponseEntity.internalServerError().build();

        log.info("submit된 회원정보 : {}", admin);



        return response;
    }
}
