package blooossom.shortping.service;

import blooossom.shortping.dto.UserDto;
import blooossom.shortping.entity.User;
import blooossom.shortping.enums.UserRole;

public interface UserService {
    boolean register(UserDto.SignUpRequest signUpRequest);
    User login(UserDto.LoginRequest loginRequest);
    void logout(String userId);
    User findUserById(String userId);
    boolean changeUserRole(String userRole, UserRole userRoleValue);
    boolean chargeCash(String userId, Integer cash);
}
