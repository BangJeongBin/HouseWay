package houseway.houseway.service.admin;

import houseway.houseway.domain.User;
import houseway.houseway.domain.UserInfoDTO;
import houseway.houseway.domain.UserPageDTO;

public interface MemberService {

    // 멤버 리스트(페이지네이션)
    UserPageDTO readMember(int cpg);

    // 멤버 상세
    UserInfoDTO readOneMember(String userId);
}
