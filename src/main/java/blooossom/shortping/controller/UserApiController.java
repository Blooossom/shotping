package blooossom.shortping.controller;

import blooossom.shortping.config.Const;
import blooossom.shortping.dto.UserDto;
import blooossom.shortping.entity.User;
import blooossom.shortping.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping(value = "/api/user", produces = Const.API_PRODUCES_JSON)
@RestController
public class UserApiController {

    private final UserService userService;

    @PostMapping(value = "/register", consumes = Const.API_CONSUMES_JSON)
    public ResponseEntity<Boolean> register(@RequestBody UserDto.SignUpRequest user) {
        return ResponseEntity.ok(userService.register(user));
    }

    @PostMapping(value = "/login", consumes = Const.API_CONSUMES_JSON)
    public ResponseEntity<?> login(@RequestBody UserDto.LoginRequest loginRequest) {
        User user = userService.login(loginRequest);
        if (user == null) {
            return ResponseEntity.ok("회원 정보를 찾을 수 없거나 비밀번호를 잘못 입력하였습니다.");
        } else {
            return ResponseEntity.ok(user);
        }
    }
}
