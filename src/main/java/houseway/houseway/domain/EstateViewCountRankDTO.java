package houseway.houseway.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EstateViewCountRankDTO {
    private String estate_id;
    private String estate_title;
    private int estate_viewCount;

}
