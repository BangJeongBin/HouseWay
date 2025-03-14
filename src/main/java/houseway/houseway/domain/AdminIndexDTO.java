package houseway.houseway.domain;

import lombok.Builder;
import lombok.Data;

@Data
public class AdminIndexDTO {
    // 모든 유저의 수를 추출
    private int userCount;
    // 모든 매물의 수를 추출
    private int estateCount;
    // 모든 공인중개사의 수를 추출
    private int agentCount;
    // 모든 예약의 수를 추출
    private int reservCount;
    // 모든 판매된 매물의 수를 추출
    private int salesCount;
    // 모든 월세 매물의 수를 추출
    private int estateRentCount;
    // 모든 전세 매물의 수를 추출
    private int estateLongRentCount;

    public AdminIndexDTO(int userCount, int estateCount, int agentCount, int reservCount, int salesCount, int estateRentCount, int estateLongRentCount) {
        this.userCount = userCount;
        this.estateCount = estateCount;
        this.agentCount = agentCount;
        this.reservCount = reservCount;
        this.salesCount = salesCount;
        this.estateRentCount = estateRentCount;
        this.estateLongRentCount = estateLongRentCount;
    }
}
