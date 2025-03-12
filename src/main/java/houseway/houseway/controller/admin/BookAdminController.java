package houseway.houseway.controller.admin;

import houseway.houseway.service.admin.BookAdminService;
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
public class BookAdminController {

    private final BookAdminService bookAdminService;


    // 예약 리스트
    @GetMapping("/book")
    public String book(Model m, @RequestParam(defaultValue = "1") int cpg, @RequestParam(defaultValue = "0") int type) {
        log.info("/admin/book 호출");

        m.addAttribute("reservDto", bookAdminService.readReserv(cpg, type));
        m.addAttribute("type", type);

        return "views/admin/estate/book";
    }


    // 예약 승인
    @GetMapping("/book_ok")
    public String bookYes(Model m, @RequestParam(defaultValue = "1") int cpg, @RequestParam("reserv_num") int reserv_num) {
        log.info("/admin/book_ok 호출");
        String returnPage = "redirect:/admin/book?cpg=" + cpg;

        // 예약 상태를 3(승인)으로 바꾸는 메서드 호출
        if (!bookAdminService.reservOk(reserv_num)) {
            returnPage = "redirect:/admin/error?type=1";
        }
        return returnPage;
    }


    // 예약 반려
    @GetMapping("/book_no")
    public String bookNo(Model m, @RequestParam(defaultValue = "1") int cpg, @RequestParam("reserv_num") int reserv_num) {
        log.info("/admin/book_no 호출");
        String returnPage = "redirect:/admin/book?cpg=" + cpg;

        // 예약 상태를 2(반려)으로 바꾸는 메서드 호출
        // 예약 상태를 3(승인)으로 바꾸는 메서드 호출
        if (!bookAdminService.reservNo(reserv_num)) {
            returnPage = "redirect:/admin/error?type=1";
        }
        return returnPage;
    }
}
