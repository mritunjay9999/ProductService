package dev.mritunjay.productservicettsmrngfeb24;

import dev.mritunjay.productservicettsmrngfeb24.controllers.ProductController;
import dev.mritunjay.productservicettsmrngfeb24.models.Product;
import dev.mritunjay.productservicettsmrngfeb24.services.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Productservicettsmrngfeb24Application {


    public static void main(String[] args) {

        Product p = new Product();
//        p.getDescription()
//        Product p = new Product()
        SpringApplication.run(Productservicettsmrngfeb24Application.class, args);
    }

}
