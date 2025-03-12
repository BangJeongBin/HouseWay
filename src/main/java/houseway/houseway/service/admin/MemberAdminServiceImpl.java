package houseway.houseway.service.admin;

import houseway.houseway.domain.*;
import houseway.houseway.repository.admin.MemberAdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MemberAdminServiceImpl implements MemberAdminService {

    private final MemberAdminRepository memberMapper;
    @Value("10") private int pageSize;


    // 멤버 리스트(페이지네이션)
    @Override
    public UserPageDTO readMember(int cpg) {
        // cpg에 따라 시작위치 값 계산
        int strnum = (cpg - 1) * pageSize;
        // 모든 회원 수
        int totalCount = memberMapper.countMember();
        // 회원 리스트
        List<UserListDTO> userList = memberMapper.memberList(strnum, pageSize);

        return new UserPageDTO(cpg, totalCount, pageSize, userList);
    }


    // 정렬 멤버 리스트(페이지네이션)
    @Override
    public UserPageDTO readSortMember(int cpg, int sno) {
        int strnum = (cpg - 1) * pageSize;
        int totalCount = memberMapper.countMember();

        if (sno == 1) {
            List<UserListDTO> userList = memberMapper.memberLocalList(strnum, pageSize);
            return new UserPageDTO(cpg, totalCount, pageSize, userList);
        } else if (sno == 2) {
            List<UserListDTO> userList = memberMapper.memberNameList(strnum, pageSize);
            return new UserPageDTO(cpg, totalCount, pageSize, userList);
        }
        return null;
    }


    // 멤버 상세
    @Transactional
    @Override
    public UserInfoDTO readOneMember(String userId) {
        // 해당 멤버 상세정보
        User userAllInfo = memberMapper.selectOneMember(userId);
        // 해당 맴버 예약 리스트
        List<Reserv> userReservList = memberMapper.selectMemberReserv(userId);
        // 해당 멤버 구매 내역 리스트
        List<Sales> userSalesList = memberMapper.selectMemberSales(userId);
        // 해당 맴버 북마크 리스트
        List<Bookmark> userBookmarkList = memberMapper.selectMemberBookmark(userId);

        return new UserInfoDTO(userAllInfo, userReservList, userSalesList, userBookmarkList);
    }

    // 멤버 삭제
    @Override
    public int removeMember(String userId) {
        return memberMapper.deleteMember(userId);
    }


    // 멤버 검색(페이지네이션)
    @Override
    public UserPageDTO findMember(int cpg, String findtype, String findkey) {
        int strnum = (cpg - 1) * pageSize;
        Map<String, Object> params = new HashMap<>();

        params.put("strnum", strnum);
        params.put("pageSize", pageSize);
        params.put("findtype", findtype);
        params.put("findkey", findkey);

        int totalCount = countFindMember(params);
        List<UserListDTO> userList = memberMapper.selectFindMember(params);

        return new UserPageDTO(cpg, totalCount, pageSize, userList);
    }


    // 멤버 검색을 위한 카운트 메서드
    @Override
    public int countFindMember(Map<String, Object> params) {
        return memberMapper.countFindMember(params);
    }
}
