package houseway.houseway.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Sales {
    private int sales_num;
    private String user_id;
    private String estate_id;
    private LocalDateTime sales_date;
    private int sales_price;
}
