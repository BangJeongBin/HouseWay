package houseway.houseway.service.admin;

import houseway.houseway.domain.*;
import houseway.houseway.repository.admin.MemberAdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberAdminServiceImpl implements MemberAdminService {

    private final MemberAdminRepository memberMapper;
    @Value("20") private int pageSize;


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
}
