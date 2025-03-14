package houseway.houseway.service.user;

import houseway.houseway.domain.MyReservDTO;
import houseway.houseway.domain.Reserv;
import houseway.houseway.repository.user.ReservRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservService {

    private final ReservRepository reservMapper;

    public List<MyReservDTO> getMyReserv(String userId) {
        List<MyReservDTO> findMyReserv = reservMapper.findMyReserv(userId);
        return findMyReserv;
    }

    public boolean deleteMyReserv(String reserv_num) {
        return reservMapper.deleteReserv(reserv_num) > 0;
    }
}
