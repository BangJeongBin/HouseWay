package houseway.houseway.domain;

import lombok.Data;

import java.util.List;

@Data
public class UserPageDTO {
    private int cpg;
    private int strBlock;
    private int totalPg;
    private int endBlock;
    private List<?> userList;

    // 페이지네이션 수식 계산
    public UserPageDTO(int cpg, int totalCount, int pageSize, List<?> userList) {
        this.cpg = cpg;
        this.totalPg = (int)Math.ceil((double)totalCount / pageSize);;  // 총 페이지 수
        this.userList = userList;

        this.strBlock = ((cpg - 1) / 10) * 10 + 1;  // 시작 블록
        this.endBlock = Math.min(strBlock + 10 - 1, totalPg);   // 끝 블록
    }
}
