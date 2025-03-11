package houseway.houseway.service.user;

import houseway.houseway.domain.Agent;
import houseway.houseway.domain.Estate;
import houseway.houseway.domain.EstateListDTO;
import houseway.houseway.domain.Reserv;

import java.util.List;

public interface EstateService {

     List<Estate> getAllEstates();

     List<EstateListDTO> searchEstates(String findtype, String findkey);

     Estate getEstateById(String estate_id);

     Agent getEstateByAgent(int agent_num);

}
