package dev.mritunjay.productservicettsmrngfeb24.services;

import dev.mritunjay.productservicettsmrngfeb24.dtos.FakeStoreProductDto;
import dev.mritunjay.productservicettsmrngfeb24.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{

//    RestTemplate (is a class under SpringBoot-web library)
//    allows to send HTTP requests to external APIs and work with responses

    private RestTemplate restTemplate;
//
    public FakeStoreProductService(RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }
    @Override
    public Product getSingleProduct(Long productId) {

        FakeStoreProductDto fakeStoreProduct = restTemplate.getForObject("https://fakestoreapi.com/products/" + productId , FakeStoreProductDto.class);
        return fakeStoreProduct.toProduct();
    }

    @Override
    public List<Product> getProducts() {
        return null;
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
}
