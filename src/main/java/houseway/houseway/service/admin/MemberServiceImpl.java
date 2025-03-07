package houseway.houseway.service.admin;

import houseway.houseway.domain.Admin;
import houseway.houseway.repository.admin.AccountRepository;
import houseway.houseway.repository.admin.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberMapper;



}
