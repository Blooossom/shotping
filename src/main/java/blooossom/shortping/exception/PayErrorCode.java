package blooossom.shortping.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum PayErrorCode {

    NOT_ENOUGH_CASH_EXCEPTION(HttpStatus.PAYMENT_REQUIRED, "잔액이 부족합니다."),
    NOT_ENOUGH_AMOUNT_EXCEPTION(HttpStatus.PAYMENT_REQUIRED, "상품의 수량이 부족합니다.");

    private HttpStatus status;
    private String message;;
}
