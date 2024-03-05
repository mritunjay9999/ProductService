package dev.mritunjay.productservicettsmrngfeb24.services;

import dev.mritunjay.productservicettsmrngfeb24.models.Product;

import java.util.List;

public interface ProductService {

    Product getSingleProduct(Long productId);
    List<Product> getProducts();

    List<Product> getAllProductsInACategory(String category);

    Product createProduct(String title,
                          String description,
                          String category,
                          double price,
                          String image);

    void deleteProduct(Long productId);

    Product updateProduct(
            Long productId,
            String title,
            String description,
            String category,
            String image,
            Double price
    );

}
