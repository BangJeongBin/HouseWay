package houseway.houseway.service.user;

import houseway.houseway.domain.*;
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
    public Estate getEstateById(String estate_id) {

        Estate estate =estateRepository.getEstateById(estate_id);
        return estateRepository.getEstateById(estate_id);
    }

    @Override
    public AgentDetailDTO getEstateByAgent(int agent_num) {
        return estateRepository.estateByAgent(agent_num);
    }

}
