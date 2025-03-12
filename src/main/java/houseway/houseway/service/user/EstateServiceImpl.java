package houseway.houseway.service.user;

import houseway.houseway.domain.*;
import houseway.houseway.repository.admin.EstateAdminRepository;
import houseway.houseway.repository.user.EstateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstateServiceImpl implements EstateService {

    private final EstateRepository estateRepository;


    @Override
    public List<Estate> getAllEstates() {
        return estateRepository.estateAllList();
    }

    @Override
    public List<EstateSearchListDTO> searchEstates(String findtype, String findkey) {

        // findkey가 비어 있으면 전체 매물을 불러오고
        if (findkey == null || findkey.isEmpty()) {
            return estateRepository.searchEstatesList();
        }
        // 검색어가 있을 경우 검색 결과를 반환
        return estateRepository.searchEstates(findtype, findkey);
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
    public List<Image> estateImageOne(String estate_id) {
        return List.of();
    }


}
