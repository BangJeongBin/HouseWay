package houseway.houseway.service.admin;

import houseway.houseway.domain.User;
import houseway.houseway.domain.UserListDTO;
import houseway.houseway.domain.UserPageDTO;
import houseway.houseway.repository.admin.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberMapper;
    @Value("20") private int pageSize;

    @Override
    public UserPageDTO readMember(int cpg) {
        // cpg에 따라 시작위치 값 계산
        int strnum = (cpg - 1) * pageSize;
        // 모든 회원 수
        int totalCount = memberMapper.countBoard();
        // 회원 리스트
        List<UserListDTO> userList = memberMapper.memberList(strnum, pageSize);

        return new UserPageDTO(cpg, totalCount, pageSize, userList);
    }
}
