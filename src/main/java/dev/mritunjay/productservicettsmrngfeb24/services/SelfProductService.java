package dev.mritunjay.productservicettsmrngfeb24.services;

import dev.mritunjay.productservicettsmrngfeb24.exceptions.ProductNotFoundException;
import dev.mritunjay.productservicettsmrngfeb24.models.Category;
import dev.mritunjay.productservicettsmrngfeb24.models.Product;
import dev.mritunjay.productservicettsmrngfeb24.repositories.CategoryRepository;
import dev.mritunjay.productservicettsmrngfeb24.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProductService")
public class SelfProductService implements ProductService{

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository , CategoryRepository categoryRepository)
    {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {
        return productRepository.findByIdIs(productId);
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getAllProductsInACategory(String category) {
        Category categoryFromDatabase = categoryRepository.findByTitle(category);

        if (categoryFromDatabase == null) {
            return null;
        } else
            return productRepository.findAllByCategory(categoryFromDatabase);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Product createProduct(String title, String description, String image, double price, String category) {
        Product product = new Product();
        product.setTitle(title);
        product.setPrice(price);
        product.setImageUrl(image);
        product.setDescription(description);

        Category categoryFromDatabase = categoryRepository.findByTitle(category);

        if(categoryFromDatabase == null)
        {
            Category newCategory = new Category();
            newCategory.setTitle(category);
            categoryFromDatabase = newCategory;
        }

        product.setCategory(categoryFromDatabase);
        Product savedProduct = productRepository.save(product);
        return savedProduct;
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public Product updateProduct(Long productId, String title, String description, String category, String image, Double price) throws ProductNotFoundException {

        Product product= getSingleProduct(productId);
        if(product == null) {
            product = new Product();
        }
        product.setId(productId);
        if(title!=null) product.setTitle(title);
        if(description!=null) product.setDescription(description);
        if(image!=null) product.setImageUrl(image);
        if(price != null) product.setPrice(price);

        Category category1 = categoryRepository.findByTitle(category);
        if(category1 == null)
        {
            category1 = new Category();
            category1.setTitle(category);
        }
        product.setCategory(category1);
        return productRepository.save(product);
    }

    @Override
    public Product updateProductUsingPatchMapping(Long productId, String title, String description, String category, String image, Double price) throws ProductNotFoundException {
        Product product= getSingleProduct(productId);
        if(product == null) {
            product = new Product();
        }
        product.setId(productId);
        if(title!=null) product.setTitle(title);
        if(description!=null) product.setDescription(description);
        if(image!=null) product.setImageUrl(image);
        if(price != null) product.setPrice(price);

        Category category1 = categoryRepository.findByTitle(category);
        if(category1 == null)
        {
            category1 = new Category();
            category1.setTitle(category);
        }
        product.setCategory(category1);
        return productRepository.save(product);
    }
}
