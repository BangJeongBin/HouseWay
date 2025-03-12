package houseway.houseway.controller.user;

import houseway.houseway.domain.AgentListDTO;
import houseway.houseway.domain.UserInsertDTO;
import houseway.houseway.service.user.AgentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequestMapping("/agent")
@RequiredArgsConstructor
public class AgentController {

    private final AgentService agentService;

    @PostMapping("/agent_login")
    public ResponseEntity<?> agentloginok(AgentListDTO agent, HttpSession session) {
        ResponseEntity<?> response = ResponseEntity.internalServerError().build();

        log.info("submit 정보 : {}", agent);
        try{
            // 정상 처리시 상태코드 200으로 응답
            AgentListDTO agentLogin = agentService.loginAgent(agent);
            session.setAttribute("agentLogin", agentLogin);
            session.setMaxInactiveInterval(600); // 세션 유지 10분

            response = ResponseEntity.ok().build();
        }catch(IllegalStateException e){
            response = ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

}
