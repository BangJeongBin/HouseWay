package houseway.houseway.controller.admin;

import houseway.houseway.service.admin.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class MemberController {

    private final MemberService memberService;


    // 회원 리스트
    @GetMapping("/member")
    public String member(Model m, @RequestParam(defaultValue = "1") int cpg) {
        log.info("/admin/member 호출");

        m.addAttribute("memberDto", memberService.readMember(cpg));

        return "views/admin/member/member";
    }


    // 회원 상세
    @GetMapping("/member_view/{user_id}")
    public String memberView(Model m, @PathVariable String user_id) {
        m.addAttribute("memDto", memberService.readOneMember(user_id));

        return "views/admin/member/member_view";
    }
}
