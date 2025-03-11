package houseway.houseway.service.admin;

import houseway.houseway.domain.*;

public interface EstateAdminService {

    // 매물 리스트(페이지네이션)
    EstatePageDTO readProduct(int cpg);

    // 매물 상세
    EstateInfoDTO readOneProduct(String estate_id);
}
