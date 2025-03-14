package houseway.houseway.service.user;

import houseway.houseway.domain.AgentDetailDTO;
import houseway.houseway.domain.Estate;
import houseway.houseway.domain.EstateSearchListDTO;
import houseway.houseway.domain.Reserv;
import houseway.houseway.repository.user.EstateRepository;
import houseway.houseway.repository.user.ReservRepository;
import houseway.houseway.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor


public class ReserveServiceImpl implements ReserveService {

    private final ReservRepository reservRepository;

    @Override
    public boolean saveReservation(String user_id, String estate_id, int agent_num, String agent_name, LocalDateTime reserv_regdate) {

        int result= reservRepository.saveReservation(user_id,estate_id,agent_num,agent_name,reserv_regdate);

        return result > 0 ? true : false;
        }
    }


