package houseway.houseway.service.user;

import houseway.houseway.domain.*;
import houseway.houseway.repository.user.EstateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class EstateServiceImpl implements EstateService {

    private final EstateRepository estateRepository;
    @Value("6") private int pageSize;

    // 매물 리스트(페이지네이션)

    @Override
    public EstateUserPageDTO readEstate(int cpg) {
        // cpg에 따라 시작위치 값 계산
        int strnum = (cpg - 1) * pageSize;
        // 모든 매물 수
        int totalEstateCount = estateRepository.countEstate();
        // 매물 리스트
        List<EstateUserListDTO> propertyList = estateRepository.estateList(strnum, pageSize);

        return new EstateUserPageDTO(cpg, totalEstateCount, pageSize, propertyList);
    }

    // 매물 검색(페이지네이션)
    @Override
    public EstateUserPageDTO findUserEstate(int cpg,  String findtype, String findkey) {
        int strnum = (cpg - 1) * pageSize;
        Map<String, Object> params = new HashMap<>();

        params.put("strnum", strnum);
        params.put("pageSize", pageSize);
        params.put("findtype", findtype);
        params.put("findkey", findkey);

        int totalEstateCount = countFindEstate(params);
        List<EstateUserListDTO> propertyList = estateRepository.selectFindUserEstate(params);
        return new EstateUserPageDTO(cpg, totalEstateCount, pageSize, propertyList);
    }



    @Override
    public int countFindEstate(Map<String, Object> params) {
        return estateRepository.countFindEstate(params);
    }



    @Override
    public EstateUserAllInfoDTO readOneUserEstate(String estate_id, int agent_num) {
        // 해당 매물의 상세 정보
        Estate getEstateById = estateRepository.getEstateById(estate_id);
        // 해당 매물의 공인증개사 정보
        AgentDetailDTO estateByAgent = estateRepository.estateByAgent(agent_num);
        // 해당 매물의 사진들
        Image estateImageOne = estateRepository.estateImageOne(estate_id);

        return new EstateUserAllInfoDTO(getEstateById, estateByAgent, estateImageOne);
    }

    @Override
    public Estate getEstateById(String estate_id) {

        Estate estate =estateRepository.getEstateById(estate_id);
        return estateRepository.getEstateById(estate_id);
    }

    @Override
    public AgentDetailDTO getEstateByAgent(int agent_num) {
        return estateRepository.estateByAgent(agent_num);
    }

    @Override
    public EstateUserPageDTO readSortEstate(int cpg, int eno) {
        int strnum = (cpg - 1) * pageSize;
        int totalCount = estateRepository.countEstate();

        if (eno == 1) {
            List<EstateUserListDTO> propertyList = estateRepository.EstateLocalList(strnum, pageSize);
            return new EstateUserPageDTO(cpg, totalCount, pageSize, propertyList);
        } else if (eno == 2) {
            List<EstateUserListDTO> propertyList = estateRepository.EstateLocalList(strnum, pageSize);
            return new EstateUserPageDTO(cpg, totalCount, pageSize, propertyList);
        }
        return null;
    }

}
