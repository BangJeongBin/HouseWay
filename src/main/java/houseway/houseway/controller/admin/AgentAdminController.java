package houseway.houseway.controller.admin;

import houseway.houseway.service.admin.AgentAdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AgentAdminController {

    private final AgentAdminService agentAdminService;


    // 공인중개사 리스트
    @GetMapping("/agent")
    public String agent(Model m, @RequestParam(defaultValue = "1") int cpg) {
        log.info("/admin/agent 호출");
        m.addAttribute("agentDto", agentAdminService.readAgent(cpg));
        return "views/admin/agent/agent";
    }


    // 공인중개사 상세
    @GetMapping("/agent_view/{agent_num}")
    public String agentView(Model m, @PathVariable int agent_num) {
        m.addAttribute("agentDto", agentAdminService.readOneAgent(agent_num));
        return "views/admin/agent/agent_view";
    }


    // 공인중개사 삭제
    @GetMapping("/agent_remove")
    public String agentRemove(Model m, @RequestParam("agent_num") int agent_num) {
        String returnUrl = "redirect:/admin/agent_view/" + agent_num;

        if (agentAdminService.removeAgent(agent_num) > 0) {
            log.info(agent_num + "삭제 완료");
            returnUrl = "redirect:/admin/agent";
        } else {
            log.info(agent_num + "삭제 실패");
        }
        return returnUrl;
    }
}
