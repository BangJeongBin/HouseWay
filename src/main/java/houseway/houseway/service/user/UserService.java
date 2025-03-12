package houseway.houseway.service.user;

import houseway.houseway.domain.User;
import houseway.houseway.domain.UserInsertDTO;
import houseway.houseway.domain.UserListDTO;
import houseway.houseway.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userMapper;

    public boolean userJoin(UserInsertDTO user) {

        // 아이디 중복 체크
        if(userMapper.countByUserid(user.getUser_id()) > 0){
            throw new IllegalStateException("이미 존재하는 아이디입니다.");
        }
        // 이메일 중복 체크
        if(userMapper.countByEmail(user.getUser_email())>0){
            throw new IllegalStateException("이미 존재하는 이메일입니다.");
        }
        int result = userMapper.insertUser(user);
        return result == 1;
    }

    public UserInsertDTO loginUser(UserInsertDTO user) {
        UserInsertDTO findUser = userMapper.findByUserId(user.getUser_id());
        if(findUser==null || !findUser.getUser_password().equals(user.getUser_password())){
            throw new IllegalStateException("아이디나 비밀번호가 일치하지 않습니다..");
        }
        return findUser;
    }

}
