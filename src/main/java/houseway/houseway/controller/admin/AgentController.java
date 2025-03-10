package houseway.houseway.controller.admin;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AgentController {



    // 공인중개사 리스트
    @GetMapping("/agent")
    public String agent(Model m, @RequestParam(defaultValue = "1") int cpg) {
        return "views/admin/agent/agent";
    }


    // 공인중개사 상세
    @GetMapping("/agent_view")
    public String agentView() {
        return "views/admin/agent/agent_view";
    }
}
