package blooossom.shortping.service;

import blooossom.shortping.entity.Product;
import blooossom.shortping.entity.User;
import blooossom.shortping.exception.ProductErrorCode;
import blooossom.shortping.exception.ProductException;
import blooossom.shortping.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class ProductApiServiceV1 implements ProductService{

    private final ProductRepository productRepository;

    @Override
    public Product getProductInfo(String productId) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product registerProduct(Product product, User user) {
        return null;
    }

    @Override
    public boolean deleteProduct(String productId, User user) {
        try {
            Product product = productRepository.findByProductId(productId)
                    .orElseThrow(() -> new ProductException(ProductErrorCode.PRODUCT_NOT_FOUND_EXCEPTION));

            if (!user.getUserId().equals(product.getSellerId())) {
                throw new ProductException(ProductErrorCode.PRODUCT_UNAUTHORIZED_EXCEPTION);
            } else {
                productRepository.delete(product);
            }
            return true;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
    }

    @Override
    public boolean updateProduct(Product product, User user) {
        return false;
    }
}
