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
    public ReservPageDTO readReserv(int cpg) {
        // cpg에 따라 시작위치 값 계산
        int strnum = (cpg - 1) * pageSize;
        // 모든 에약 수
        int totalCount = bookMapper.countReserv();
        // 예약 리스트
        List<ReservListDTO> reservList = bookMapper.reservList(strnum, pageSize);

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
