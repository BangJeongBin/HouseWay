package houseway.houseway.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EstateUserListDTO {
    private String estate_id;
    private String estate_gu;
    private String estate_title;
    private int agent_num;
    private int estate_deposit;
    private int estate_rent;
}
