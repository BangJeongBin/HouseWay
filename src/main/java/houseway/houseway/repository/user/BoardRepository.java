package houseway.houseway.repository.user;

import houseway.houseway.domain.Board;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BoardRepository {
    @Select("select * from board")
    public List<Board> allBoard();

    @Select("select * from board where board_num = #{board_num}")
    public Board findOneBoard(String board_num);
}
