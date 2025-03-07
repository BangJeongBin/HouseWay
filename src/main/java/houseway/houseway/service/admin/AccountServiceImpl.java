package houseway.houseway.service.admin;

import houseway.houseway.repository.admin.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository AccountMapper;
}
