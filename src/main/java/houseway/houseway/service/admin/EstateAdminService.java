package houseway.houseway.service.admin;

import houseway.houseway.domain.EstatePageDTO;
import houseway.houseway.domain.UserInfoDTO;
import houseway.houseway.domain.UserPageDTO;

public interface EstateAdminService {

    // 매물 리스트(페이지네이션)
    EstatePageDTO readProduct(int cpg);
}
