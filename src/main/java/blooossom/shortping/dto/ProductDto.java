package blooossom.shortping.dto;

import lombok.Data;

@Data
public class ProductDto {

    @Data
    public static class UpdateProductRequest {
        private String productId;

        private String productName;

        private String description;

        private Integer price;

        private Integer amount;

    }
}
