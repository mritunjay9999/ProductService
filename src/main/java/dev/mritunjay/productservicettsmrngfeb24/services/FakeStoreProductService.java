package dev.mritunjay.productservicettsmrngfeb24.services;

import dev.mritunjay.productservicettsmrngfeb24.dtos.FakeStoreProductDto;
import dev.mritunjay.productservicettsmrngfeb24.exceptions.ProductNotFoundException;
import dev.mritunjay.productservicettsmrngfeb24.models.Product;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{

//    RestTemplate (is a class under SpringBoot-web library)
//    allows to send HTTP requests to external APIs and work with responses
//    RestTemplate class has a library Jackson --> work is to convert JSON file into Java object

    private RestTemplate restTemplate;
//
    public FakeStoreProductService(RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }
//    @Override
//    public Product getSingleProduct(Long productId) {
//
//        FakeStoreProductDto fakeStoreProduct = restTemplate.getForObject("https://fakestoreapi.com/products/" + productId , FakeStoreProductDto.class);
//        return fakeStoreProduct.toProduct();
//    }
public Product getSingleProduct(Long productId) throws ProductNotFoundException {

    ResponseEntity<FakeStoreProductDto> fakeStoreProductResponse = restTemplate.getForEntity(
            "https://fakestoreapi.com/products/" + productId,
            FakeStoreProductDto.class
    );

//    if (fakeStoreProductResponse.getStatusCode() != HttpStatusCode.valueOf(200)) {
//
//    }
//
//        if (fakeStoreProductResponse.getStatusCode() != HttpStatusCode.valueOf(200)) {
//
//        }

//        fakeStoreProductResponse.getHeaders().

    FakeStoreProductDto fakeStoreProduct = fakeStoreProductResponse.getBody();

    if (fakeStoreProduct == null) {
        throw new ProductNotFoundException("Product with id: " + productId + " doesn't exist.Please retry with some other productId.");
    }

    return fakeStoreProduct.toProduct();
}
























    @Override
    public List<Product> getProducts() {

        List<Product> productList = new ArrayList<>();

        FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForObject("https://fakestoreapi.com/products" , FakeStoreProductDto[].class);
        for(int i=0;i<fakeStoreProductDtos.length;i++)
        {
            productList.add(fakeStoreProductDtos[i].toProduct());
        }

        return productList;
    }

    @Override
    public List<Product> getAllProductsInACategory(String category) {

        List<Product> productList = new ArrayList<>();

        FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForObject("https://fakestoreapi.com/products/category/" + category , FakeStoreProductDto[].class);
        for(int i=0;i<fakeStoreProductDtos.length;i++)
        {
            productList.add(fakeStoreProductDtos[i].toProduct());
        }
        return productList;
    }

    @Override
    public Product createProduct(String title,
                                 String  description,
                                 String category,
                                 double price,
                                 String image) {

        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setTitle(title);
        fakeStoreProductDto.setCategory(category);
        fakeStoreProductDto.setImage(image);
        fakeStoreProductDto.setPrice(price);
        fakeStoreProductDto.setDescription(description);

        FakeStoreProductDto response = restTemplate.postForObject("https://fakestoreapi.com/products" , // make a POST request at this URL
                fakeStoreProductDto , // This is request body , in requestbody send the data
                FakeStoreProductDto.class); // this is datatype of response. When response JSON will come , convert it into an object of this class

        return response.toProduct();
    }

    @Override
    public void deleteProduct(Long productId) {
        restTemplate.delete("https://fakestoreapi.com/products/" + productId);
    }


    // FakeStore wont allow to update the products , so behind the scenes update method does nothing
    // when we return products/1 we get the same product as earlier
    @Override
    public Product updateProduct(Long productId, String title, String description, String category, String image, Double price) throws ProductNotFoundException {

        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setId(productId);

        if(title != null) fakeStoreProductDto.setTitle(title);
        if(category != null) fakeStoreProductDto.setCategory(category);
        if(image != null) fakeStoreProductDto.setImage(image);
        if(price != null) fakeStoreProductDto.setPrice(price);
        if(description != null)fakeStoreProductDto.setDescription(description);

        restTemplate.put("https://fakestoreapi.com/products/" + productId , fakeStoreProductDto);

        return getSingleProduct(productId);
    }


}
