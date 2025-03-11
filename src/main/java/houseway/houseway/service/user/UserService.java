package houseway.houseway.service.user;

import houseway.houseway.domain.User;
import houseway.houseway.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userMapper;

    public boolean userJoin(User user) {

        // 아이디 중복 체크
        if(userMapper.countByUserid(user.getUser_id()) > 0){
            throw new IllegalStateException("이미 존재하는 아이디입니다.");
        }
        // 이메일 중복 체크
        if(userMapper.countByEmail(user.getUser_email())>0){
            throw new IllegalStateException("이미 존재하는 이메일입니다.");
        }
        int result = userMapper.insertMember(user);
        return result == 1;//회원정보가 테이블 저장되었는지 여부에 따라 true/false 반환
    }

    public User loginMember(User user) {
        User findMember = userMapper.findByUserId(user.getUser_id());
        if(findMember==null || !findMember.getUser_password().equals(user.getUser_password())){
            throw new IllegalStateException("아이디나 비밀번호가 일치하지 않습니다..");
        }
        return findMember;
    }

}
