package houseway.houseway.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EstateListDTO {
    private String estate_id;
    private String estate_title;
    private String estate_addr;
    private int estate_deposit;
    private int estate_rent;
    private int estate_viewCount;
    private int estate_state;
}
