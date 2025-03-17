package houseway.houseway.service.user;

import houseway.houseway.domain.*;

import java.util.List;
import java.util.Map;

public interface EstateService {

     // 매물 상세 정보
     EstateUserAllInfoDTO readOneUserEstate(String estate_id, int agent_num);

     // estate_id로 모든 정보 받아오기
     Estate getEstateById(String estate_id);

     // 공인중개사 세부사항
     AgentDetailDTO getEstateByAgent(int agent_num);

     //정렬 매물 리스트(페이지네이션)
     EstateUserPageDTO readSortEstate(int cpg, int eno);

     EstateUserPageDTO readEstate(int cpg);

     // 매물 검색(페이지네이션)
     EstateUserPageDTO findUserEstate(int cpg, String findtype, String findkey);

     // 매물 검색 위한 카운트 메서드
     int countFindEstate(Map<String, Object> params);


}
