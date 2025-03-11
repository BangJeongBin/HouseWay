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

    private final EstateAdminRepository estateMapper;
    @Value("10") private int pageSize;


    // 매물 리스트(페이지네이션)
    @Override
    public EstatePageDTO readProduct(int cpg) {
        // cpg에 따라 시작위치 값 계산
        int strnum = (cpg - 1) * pageSize;
        // 모든 매물 수
        int totalCount = estateMapper.countEstate();
        // 모든 매물 리스트
        List<EstateListDTO> estateList = estateMapper.estateList(strnum, pageSize);
        // 모든 매물 사진 리스트
        List<Image> estateImageList = estateMapper.estateImageList();

        return new EstatePageDTO(cpg, totalCount, pageSize, estateList, estateImageList);
    }

    // 매물 상세
    @Transactional
    @Override
    public EstateInfoDTO readOneProduct(String estate_id) {
        // 해당 매물 상세정보
        Estate estateAllInfo = estateMapper.selectOneEstate(estate_id);
        // 모든 매물 사진들
        Image estateImages = estateMapper.selectEstateImages(estate_id);
        // 해당 매물 예약 상태
        Reserv estateReservState = estateMapper.selectEstateReservState(estate_id);
        // 해당 매물 북마크 리스트
        List<Bookmark> estateBookmarkList = estateMapper.selectEstateBookmark(estate_id);

        return new EstateInfoDTO(estateAllInfo, estateImages, estateReservState, estateBookmarkList);
    }
}
