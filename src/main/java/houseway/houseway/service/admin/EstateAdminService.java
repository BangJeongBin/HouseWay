package houseway.houseway.service.admin;

import houseway.houseway.domain.*;

import java.util.Map;

public interface EstateAdminService {

    // 매물 리스트(페이지네이션)
    EstatePageDTO readProduct(int cpg);

    // 정렬 매물 리스트(페이지네이션)
    EstatePageDTO readSortEstate(int cpg, int sno);

    // 매물 상세
    EstateInfoDTO readOneProduct(String estateId);

    // 매물 수정 확정
    boolean modifyEstateOk(EstateModifyDTO estate);

    // 매물 삭제
    int removeEstate(String estateId);

    // 매물 검색(페이지네이션)
    EstatePageDTO findEstate(int cpg, String findtype, String findkey);

    // 매물 검색을 위한 카운트 메서드
    int countFindEstate(Map<String, Object> params);
}
