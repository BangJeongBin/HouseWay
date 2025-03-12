package houseway.houseway.service.admin;

import houseway.houseway.domain.ReservPageDTO;
import houseway.houseway.domain.UserInfoDTO;
import houseway.houseway.domain.UserPageDTO;

import java.util.Map;

public interface BookAdminService {

    //  예약 리스트(페이지네이션)
    ReservPageDTO readReserv(int cpg, int type);

    // 예약 상태를 3(승인)으로 바꾸는 메서드 호출
    boolean reservOk(int reservNum);

    // 예약 상태를 2(반려)으로 바꾸는 메서드 호출
    boolean reservNo(int reservNum);
}
