package houseway.houseway.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Board {
    private int board_num;
    private String user_id;
    private String board_category;
    private String board_title;
    private String board_cont;
    private LocalDateTime board_regdate;
    private LocalDateTime board_update;
    private int board_views;
    private int board_rank;
}
