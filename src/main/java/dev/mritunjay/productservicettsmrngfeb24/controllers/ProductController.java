package dev.mritunjay.productservicettsmrngfeb24.controllers;

import dev.mritunjay.productservicettsmrngfeb24.dtos.CreateProductRequestDto;
import dev.mritunjay.productservicettsmrngfeb24.models.Product;
import dev.mritunjay.productservicettsmrngfeb24.services.ProductService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ProductController {

//    private Map<Integer, Integer> map = new HashMap<>();
//    List<Integer> list = new ArrayList<>();
//    Like the above statements the below statement is written i.e. only RHS changed in future

    private ProductService productService;
//    private ProductService productService2 = new FakeStoreProductService();

    private RestTemplate restTemplate;

    public ProductController(ProductService productService , RestTemplate restTemplate)
    {
        this.productService = productService;
        this.restTemplate = restTemplate;
    }

//    POST / products
//    RequestBody
//        {
//           Title:
//           description:
//           price:
//        }

    @PostMapping("/products")
    public Product createProduct(@RequestBody CreateProductRequestDto request)
    {
        return productService.createProduct(
                request.getTitle(),
                request.getDescription(),
                request.getImage(),
                request.getPrice(),
                request.getCategory()
        );
    }

//    Get / products / 1
//    Get / products / 200
//    Get / products / 201
    @GetMapping("/products/{id}")
    public Product getProductDetails(@PathVariable("id") Long productId)
    {
        return productService.getSingleProduct(productId);
    }

    @GetMapping("/products")
    public List<Product> getAllProduct()
    {
        return productService.getProducts();
    }

    @GetMapping("/products/categories")
    public String[] getAllCategories()
    {
        return restTemplate.getForObject("https://fakestoreapi.com/products/categories" , String[].class);
    }

    public void updateProduct()
    {

    }
}
