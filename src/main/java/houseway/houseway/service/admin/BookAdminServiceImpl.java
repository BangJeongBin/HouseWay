package houseway.houseway.service.admin;

import houseway.houseway.domain.*;
import houseway.houseway.repository.admin.BookAdminRepository;
import houseway.houseway.repository.admin.MemberAdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BookAdminServiceImpl implements BookAdminService {

    private final BookAdminRepository bookAdminMapper;
    @Value("10") private int pageSize;

    /
}
