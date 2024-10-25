package blooossom.shortping.service;

import blooossom.shortping.entity.Product;
import blooossom.shortping.entity.User;

import java.util.List;

public interface ProductService {

    Product getProductInfo(String productId);

    List<Product> getAllProducts();

    Product registerProduct(Product product, User user);

    boolean deleteProduct(String productId, User user);

    boolean updateProduct(Product product, User user);
}
