package houseway.houseway.controller.admin;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class BoardController {

    // 공지사항 목록
    @GetMapping("/notice")
    public String notice() {
        return "views/admin/board/notice";
    }


    // 게시판 목록
    @GetMapping("/board")
    public String board() {
        return "views/admin/board/board";
    }


    // 뉴스 목록
    @GetMapping("/news")
    public String news() {
        return "views/admin/board/news";
    }
}
