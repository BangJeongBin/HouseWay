package houseway.houseway.service.admin;

import houseway.houseway.domain.*;
import houseway.houseway.repository.admin.EstateAdminRepository;
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


    // 정렬 매물 리스트(페이지네이션)
    @Override
    public EstatePageDTO readSortEstate(int cpg, int sno) {
        int strnum = (cpg - 1) * pageSize;
        int totalCount = estateMapper.countEstate();
        // 모든 매물 사진 리스트
        List<Image> estateImageList = estateMapper.estateImageList();

        if (sno == 1) {
            List<EstateListDTO> estateList = estateMapper.estateHitList(strnum, pageSize);
            return new EstatePageDTO(cpg, totalCount, pageSize, estateList, estateImageList);
        } else if (sno == 2) {
            List<EstateListDTO> estateList = estateMapper.estateOnsaleList(strnum, pageSize);
            return new EstatePageDTO(cpg, totalCount, pageSize, estateList, estateImageList);
        } else if (sno == 3) {
            List<EstateListDTO> estateList = estateMapper.estateUnsaleList(strnum, pageSize);
            return new EstatePageDTO(cpg, totalCount, pageSize, estateList, estateImageList);
        }
        return null;
    }


    // 매물 상세
    @Transactional
    @Override
    public EstateInfoDTO readOneProduct(String estateId) {
        // 해당 매물 상세정보
        Estate estateAllInfo = estateMapper.selectOneEstate(estateId);
        // 모든 매물 사진들
        Image estateImages = estateMapper.selectEstateImages(estateId);
        // 해당 매물 예약 상태
        Reserv estateReservState = estateMapper.selectEstateReservState(estateId);
        // 해당 매물 북마크 리스트
        List<Bookmark> estateBookmarkList = estateMapper.selectEstateBookmark(estateId);

        return new EstateInfoDTO(estateAllInfo, estateImages, estateReservState, estateBookmarkList);
    }


    // 매물 수정 확정
    @Override
    public boolean modifyEstateOk(EstateModifyDTO estate) {
        int result = estateMapper.updateEstateInfo(estate);

        return result == 1;
    }


    // 매물 삭제
    @Override
    public int removeEstate(String estateId) {
        return estateMapper.deleteEstate(estateId);
    }


    // 매물 검색(페이지네이션)
    @Override
    public EstatePageDTO findEstate(int cpg, String findtype, String findkey) {
        int strnum = (cpg - 1) * pageSize;
        Map<String, Object> params = new HashMap<>();

        params.put("strnum", strnum);
        params.put("pageSize", pageSize);
        params.put("findtype", findtype);
        params.put("findkey", findkey);

        //  매물 사진 리스트
        int totalCount = countFindEstate(params);
        // 검색된 매물 리스트
        List<EstateListDTO> estateList = estateMapper.selectFindEstate(params);
        // 모든 매물 사진 리스트
        List<Image> estateImageList = estateMapper.estateImageList();

        return new EstatePageDTO(cpg, totalCount, pageSize, estateList, estateImageList);
    }


    // 매물 검색을 위한 카운트 메서드
    @Override
    public int countFindEstate(Map<String, Object> params) {
        return estateMapper.countFindEstate(params);
    }
}
