package dev.mritunjay.productservicettsmrngfeb24.controllers;

import dev.mritunjay.productservicettsmrngfeb24.dtos.CreateProductRequestDto;
import dev.mritunjay.productservicettsmrngfeb24.dtos.UpdateProductRequestDto;
import dev.mritunjay.productservicettsmrngfeb24.dtos.UpdateProductRequestDto;
import dev.mritunjay.productservicettsmrngfeb24.exceptions.ProductNotFoundException;
import dev.mritunjay.productservicettsmrngfeb24.models.Product;
import dev.mritunjay.productservicettsmrngfeb24.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

//    public ProductController(ProductService productService , RestTemplate restTemplate)
    public ProductController(@Qualifier("selfProductService") ProductService productService , RestTemplate restTemplate)
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
    public Product getProductDetails(@PathVariable("id") Long productId) throws ProductNotFoundException
    {
        return productService.getSingleProduct(productId);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() throws ProductNotFoundException
    {
        List<Product> products = productService.getProducts();

//        throw new ProductNotFoundException("This is a new Exception created by MJ");

        ResponseEntity<List<Product>> response = new ResponseEntity<>(products , HttpStatus.OK); // gives status code in Postman 404 Not found or 302 Found etc.

//        response.getHeaders().add("My name" , "Mritunjay Gupta");
        return response;
    }

    @GetMapping("/products/categories")
    public String[] getAllCategories()
    {
        return restTemplate.getForObject("https://fakestoreapi.com/products/categories" , String[].class);
    }

    @GetMapping("/products/category/{category}")
    public List<Product> getAllProductsInACategory(@PathVariable("category") String category)
    {
        return productService.getAllProductsInACategory(category);
    }

    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable("id") Long productId ,@RequestBody UpdateProductRequestDto request) throws ProductNotFoundException {
        return productService.updateProduct(
                productId,
                request.getTitle(),
                request.getDescription(),
                request.getImage(),
                request.getCategory(),
                request.getPrice()
        );
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable("id") Long productId)
    {
        if(productId != null)
        {
            productService.deleteProduct(productId);
            System.out.println("Deleted Successfully: " + productId);
        }

        else {
            System.out.println("There is no record existing with that productId");
        }
    }

//    @ExceptionHandler(ProductNotFoundException.class)
//    public ResponseEntity<ErrorDto> handleProductNotFoundException(ProductNotFoundException exception)
//    {
//
//        ErrorDto errorDto = new ErrorDto();
//        errorDto.setMessage(exception.getMessage());
//
//        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
//        return null;
//    }

    // Limited to only the exceptions thrown from this controller
    // Controller Advices: Global

    // if this controller ever ends up throwing ProductNotFoundException.class
    // for any reason, don't throw that exception as is.
    // Instead, call this method and return what this method is returning
}
