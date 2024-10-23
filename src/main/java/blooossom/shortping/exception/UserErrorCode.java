package blooossom.shortping.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum UserErrorCode {

    PASSWORD_NOT_CORRECT_EXCEPTION(HttpStatus.UNAUTHORIZED, "잘못된 비밀번호입니다."),
    USER_NOT_FOUND_EXCEPTION(HttpStatus.UNAUTHORIZED, "유저를 찾을 수 없습니다.");

    private HttpStatus status;
    private String message;
}
