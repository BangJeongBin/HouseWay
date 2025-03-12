package houseway.houseway.service.user;

import houseway.houseway.domain.*;

import java.util.List;

public interface EstateService {

     List<Estate> getAllEstates();

     List<EstateSearchListDTO> searchEstates(String findtype, String findkey);

     Estate getEstateById(String estate_id);

     AgentDetailDTO getEstateByAgent(int agent_num);

}
