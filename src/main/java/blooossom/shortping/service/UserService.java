package blooossom.shortping.service;

import blooossom.shortping.dto.UserDto;
import blooossom.shortping.entity.User;

public interface UserService {
    void register(UserDto.SignUpRequest signUpRequest);
    User login(String userId, String password);
    void logout(String userId);
    User findUserById(String userId);
}
