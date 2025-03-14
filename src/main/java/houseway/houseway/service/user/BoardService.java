package houseway.houseway.service.user;

import houseway.houseway.domain.Board;
import houseway.houseway.repository.user.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public List<Board> allBoard() {
        return boardRepository.allBoard();
    }

    public Board findOneBoard(String board_num) {
        return boardRepository.findOneBoard(board_num);
    }
}
