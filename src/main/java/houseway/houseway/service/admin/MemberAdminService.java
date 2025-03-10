package houseway.houseway.service.admin;

import houseway.houseway.domain.UserInfoDTO;
import houseway.houseway.domain.UserPageDTO;

public interface MemberAdminService {

    // 멤버 리스트(페이지네이션)
    UserPageDTO readMember(int cpg);

    // 멤버 상세
    UserInfoDTO readOneMember(String userId);

    // 멤버 삭제
    int removeMember(String userId);
}
