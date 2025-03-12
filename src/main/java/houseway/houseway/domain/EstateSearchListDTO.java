package houseway.houseway.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EstateSearchListDTO {
    private String estate_id;
    private String estate_title;
    private int estate_deposit;
    private int estate_rent;

}
