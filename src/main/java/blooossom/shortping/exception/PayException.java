package blooossom.shortping.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PayException extends RuntimeException{

    private PayErrorCode errorCode;

    private String message;

    public PayException(PayErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String getMessage() {
        if(message == null){
            return "{" +
                    "\"state\":" + "\"" + errorCode.getStatus() + "\"" + "\n" +
                    "\t" + "\"message\":" + errorCode.getMessage() +
                    "}";
        }
        return "{" +
                "\"state\":" + "\"" + errorCode.getStatus() + "\"" + "\n" +
                "\t" + "\"message\":" + message +
                "}";
    }
}
