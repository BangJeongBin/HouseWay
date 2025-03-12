package houseway.houseway.domain;

import lombok.Data;

import java.util.List;

@Data
public class ReservPageDTO {
    private int cpg;
    private int strBlock;
    private int totalCount;
    private int endBlock;
    private List<?> reservList;

    // 페이지네이션 수식 계산
    public ReservPageDTO(int cpg, int totalCount, int pageSize, List<?> reservList) {
        this.cpg = cpg;
        this.totalCount = (int)Math.ceil((double)totalCount / pageSize);;  // 총 페이지 수
        this.reservList = reservList;

        this.strBlock = ((cpg - 1) / 5) * 5 + 1;  // 시작 블록
        this.endBlock = Math.min(strBlock + 5 - 1, totalCount);   // 끝 블록
    }
}
