package houseway.houseway.controller.admin;

import houseway.houseway.service.admin.MemberAdminService;
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
public class MemberAdminController {

    private final MemberAdminService memberAdminService;


    // 회원 리스트
    @GetMapping("/member")
    public String member(Model m, @RequestParam(defaultValue = "1") int cpg) {
        log.info("/admin/member 호출");
        m.addAttribute("memberDto", memberAdminService.readMember(cpg));

        return "views/admin/member/member";
    }


    // 회원 상세
    @GetMapping("/member_view/{user_id}")
    public String memberView(Model m, @PathVariable String user_id) {
        m.addAttribute("memDto", memberAdminService.readOneMember(user_id));

        return "views/admin/member/member_view";
    }


    // 회원 삭제
    @GetMapping("/member_remove")
    public String memberRemove(Model m, @PathVariable String user_id) {
        m.addAttribute("memDto", memberAdminService.readOneMember(user_id));

        return "views/admin/member/member_view";
    }
}
