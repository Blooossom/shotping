package blooossom.shortping.controller;

import blooossom.shortping.dto.UserDto;
import blooossom.shortping.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping(name = "/api/user")
@RestController
public class UserApiController {

    private final UserService userService;

    @PostMapping("")
    public void register(@RequestBody UserDto.SignUpRequest user) {
        userService.register(user);
    }
}
