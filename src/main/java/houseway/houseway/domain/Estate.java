package houseway.houseway.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Estate {
    private String estate_id;
    private int agent_num;
    private String estate_title;
    private String estate_desc;
    private String estate_addr;
    private String estate_gu;
    private double estate_lat;
    private double estate_lng;
    private int estate_deposit;
    private int estate_rent;
    private String estate_area;
    private String estate_amount;
    private String estate_type;
    private String estate_service;
    private String estate_roomType;
    private String estate_parking;
    private String estate_elev;
    private String estate_moveDate;
    private String estate_option;
    private int estate_viewCount;
    private int estate_state;

}
