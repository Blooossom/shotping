package blooossom.shortping.dto;

import blooossom.shortping.config.Const;
import blooossom.shortping.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
public class UserDto {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor(force = true)
    public static class SignUpRequest {

        private final String userId;

        private final String password;

        private final String userName;

        private final String email;

        private final String phoneNum;

        private final String address;

        private final String addressDetail;

        private final String gender;

        private final String birth;

        public static User toEntity(SignUpRequest signUpRequest, String userSeq) {
            return User.builder()
                    .userSeq(userSeq)
                    .userId(signUpRequest.getUserId())
                    .password(signUpRequest.getPassword())
                    .userName(signUpRequest.getUserName())
                    .email(signUpRequest.getEmail())
                    .phoneNum(signUpRequest.getPhoneNum())
                    .address(signUpRequest.getAddress())
                    .addressDetail(signUpRequest.getAddressDetail())
                    .gender(signUpRequest.getGender())
                    .birth(signUpRequest.getBirth())
                    .build();
        }
    }

    @Getter
    @AllArgsConstructor
    public static class LoginRequest {
        private final String userId;
        private final String password;
    }
}
