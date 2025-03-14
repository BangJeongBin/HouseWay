package houseway.houseway.controller.user;

import houseway.houseway.domain.Board;
import houseway.houseway.service.user.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;
    @GetMapping("/list")
    public String allBoardList(Model model) {

        List<Board> allboard = boardService.allBoard();
        model.addAttribute("board", allboard);

        return "views/user/board_list";
    }

    @GetMapping("/detail/{board_num}")
    public String boardDetail(Model model, @PathVariable String board_num) {
        System.err.println("asdf");
        model.addAttribute("board", boardService.findOneBoard(board_num));
        System.err.println(board_num);
        System.err.println("게시글" + model.getAttribute("board"));
        return "views/user/boardCont";
    }
}
