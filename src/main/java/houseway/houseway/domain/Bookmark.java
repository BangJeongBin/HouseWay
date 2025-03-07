package houseway.houseway.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Bookmark {
    private int bookmark_num;
    private String user_id;
    private String estate_id;
}
