package blooossom.shortping.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ProductErrorCode {

    PRODUCT_REGISTER_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR, "등록 실패하였습니다."),
    PRODUCT_NOT_FOUND_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR, "상품을 찾을 수 없습니다."),
    PRODUCT_UNAUTHORIZED_EXCEPTION(HttpStatus.UNAUTHORIZED, "상품에 대한 권한이 없습니다.");

    private HttpStatus status;
    private String message;
}
