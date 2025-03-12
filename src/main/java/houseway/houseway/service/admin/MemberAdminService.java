package houseway.houseway.service.admin;

import houseway.houseway.domain.UserInfoDTO;
import houseway.houseway.domain.UserPageDTO;

import java.util.Map;

public interface MemberAdminService {

    // 멤버 리스트(페이지네이션)
    UserPageDTO readMember(int cpg);

    // 정렬 멤버 리스트(페이지네이션)
    UserPageDTO readSortMember(int cpg, int sno);

    // 멤버 상세
    UserInfoDTO readOneMember(String userId);

    // 멤버 삭제
    int removeMember(String userId);

    // 멤버 검색(페이지네이션)
    UserPageDTO findMember(int cpg, String findtype, String findkey);

    // 멤버 검색을 위한 카운트 메서드
    int countFindMember(Map<String, Object> params);
}
