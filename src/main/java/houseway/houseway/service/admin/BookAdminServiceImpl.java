package houseway.houseway.service.admin;

import houseway.houseway.domain.*;
import houseway.houseway.repository.admin.BookAdminRepository;
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
public class BookAdminServiceImpl implements BookAdminService {

    private final BookAdminRepository bookMapper;
    @Value("10") private int pageSize;


    //  예약 리스트(페이지네이션)
    @Override
    public ReservPageDTO readReserv(int cpg, int type) {
        // cpg에 따라 시작위치 값 계산
        int strnum = (cpg - 1) * pageSize;

        int totalCount = 0;
        List<ReservListDTO> reservList = null;

        switch (type) {
            case 0:
                // 모든 예약
                totalCount = bookMapper.countReserv();
                reservList = bookMapper.reservList(strnum, pageSize);
                break;
            case 1:
                // 성공 예약
                totalCount = bookMapper.countReservSuccess();
                reservList = bookMapper.reservListSuccess(strnum, pageSize);
                break;
            case 2:
                // 대기 예약
                totalCount = bookMapper.countReservPending();
                reservList = bookMapper.reservListPending(strnum, pageSize);
                break;
            case 3:
                // 반려 예약
                totalCount = bookMapper.countReservCancelled();
                reservList = bookMapper.reservListCancelled(strnum, pageSize);
                break;
        }

        return new ReservPageDTO(cpg, totalCount, pageSize, reservList);
    }


    // 예약 상태를 3(승인)으로 바꾸는 메서드 호출
    @Override
    public boolean reservOk(int reservNum) {
        int stateOk = bookMapper.reservStateOk(reservNum);

        return stateOk > 0;
    }


    // 예약 상태를 2(반려)으로 바꾸는 메서드 호출
    @Override
    public boolean reservNo(int reservNum) {
        int stateNo = bookMapper.reservStateNo(reservNum);

        return stateNo > 0;
    }
}
