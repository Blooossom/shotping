package blooossom.shortping.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductException extends RuntimeException {

    private ProductErrorCode errorCode;
    private String message;

    public ProductException(ProductErrorCode errorCode) {
        this.errorCode = errorCode;
    }
    @Override
    public String getMessage(){
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
