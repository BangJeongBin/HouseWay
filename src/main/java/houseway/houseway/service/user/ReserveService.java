package houseway.houseway.service.user;

import houseway.houseway.domain.AgentDetailDTO;
import houseway.houseway.domain.Estate;
import houseway.houseway.domain.EstateSearchListDTO;
import houseway.houseway.domain.Reserv;

import java.time.LocalDateTime;
import java.util.List;

public interface ReserveService {

     boolean saveReservation(String user_id, String estate_id, int agent_num, String agent_name, LocalDateTime reserv_regdate);

     Reserv getReservInfo(String userId);
}


