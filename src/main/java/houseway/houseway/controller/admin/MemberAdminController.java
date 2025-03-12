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


    // 회원 정렬 리스트
    @GetMapping("/member_sort")
    public String member(Model m, @RequestParam(defaultValue = "1") int cpg, @RequestParam("sno") int sno) {
        log.info("/admin/member_sort 호출");
        m.addAttribute("memberDto", memberAdminService.readSortMember(cpg, sno));

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
    public String memberRemove(Model m, @RequestParam("user_id") String user_id) {
        String returnUrl = "redirect:/admin/member_view/" + user_id;

        if (memberAdminService.removeMember(user_id) > 0) {
            log.info(user_id + "삭제 완료");
            returnUrl = "redirect:/admin/member";
        } else {
            log.info(user_id + "삭제 실패");
        }
        return returnUrl;
    }


    // 회원 검색
    @GetMapping("/member_find")
    public String find(Model m, @RequestParam(defaultValue = "1") int cpg, String findtype, String findkey) {

        m.addAttribute("memberDto", memberAdminService.findMember(cpg, findtype, findkey));

        return "views/admin/member/member";
    }
}
