package houseway.houseway.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EstateModifyDTO {
    private String estate_id;
    private String estate_title;
    private int estate_deposit;
    private int estate_rent;
    private String estate_area;
    private String estate_amount;
    private String estate_type;
    private String estate_service;
    private String estate_moveDate;
    private String estate_option;
}
