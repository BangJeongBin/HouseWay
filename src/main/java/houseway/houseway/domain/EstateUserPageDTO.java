package houseway.houseway.domain;

import lombok.Data;

import java.util.List;

@Data
public class EstateUserPageDTO {

    private int cpg;
    private int strBlock;
    private int totalPg;
    private int endBlock;
    private List<?> estateList;

    // 페이지네이션 수식 계산
    public EstateUserPageDTO(int cpg, int totalEstateCount, int pageSize, List<?> propertyList) {
        this.cpg = cpg;
        this.totalPg = (int)Math.ceil((double)totalEstateCount / pageSize);;  // 총 페이지 수
        this.estateList = propertyList;

        this.strBlock = ((cpg - 1) / 5) * 5 + 1;  // 시작 블록
        this.endBlock = Math.min(strBlock + 5 - 1, totalPg);   // 끝 블록
    }
}