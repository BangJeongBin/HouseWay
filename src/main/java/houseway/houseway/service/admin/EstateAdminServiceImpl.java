package houseway.houseway.service.admin;

import houseway.houseway.domain.*;
import houseway.houseway.repository.admin.EstateAdminRepository;
import houseway.houseway.repository.admin.MemberAdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstateAdminServiceImpl implements EstateAdminService {

    private final EstateAdminRepository memberMapper;
    @Value("10") private int pageSize;


    // 매물 리스트(페이지네이션)
    @Override
    public EstatePageDTO readProduct(int cpg) {
        // cpg에 따라 시작위치 값 계산
        int strnum = (cpg - 1) * pageSize;
        // 모든 회원 수
        int totalCount = memberMapper.countEstate();
        // 회원 리스트
        List<EstateListDTO> estateList = memberMapper.estateList(strnum, pageSize);

        return new EstatePageDTO(cpg, totalCount, pageSize, estateList);
    }
}
