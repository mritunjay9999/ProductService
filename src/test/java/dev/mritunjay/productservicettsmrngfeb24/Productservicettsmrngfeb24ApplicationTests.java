package dev.mritunjay.productservicettsmrngfeb24;

import dev.mritunjay.productservicettsmrngfeb24.repositories.CategoryRepository;
import dev.mritunjay.productservicettsmrngfeb24.repositories.ProductRepository;
import dev.mritunjay.productservicettsmrngfeb24.repositories.projections.ProductProjection;
import dev.mritunjay.productservicettsmrngfeb24.repositories.projections.ProductWithTitleAndId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Productservicettsmrngfeb24ApplicationTests {

//    To put a Spring bean in test case we need to annotate the bean with autowired
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testingQueries()
    {
//        productRepository.findByIdIs(102L);
//        productRepository.findAllByTitle("Hello");
//          productRepository.findFirstByIdIs(2L);
        productRepository.getProductWithCategoryNameAndProductId("phones" , 4L);

        List<String> pros1 = productRepository.getTitlesOfAllProductsInACategory(4L);
        System.out.println(pros1);

        List<ProductProjection> pros2 = productRepository.getTitlesAndIdsOfAllProductsInACategory(4L);
        System.out.println(pros2);
        System.out.println(pros2.get(0).getId());
        System.out.println(pros2.get(0).getTitle());
    }

}

//Productservicettsmrngfeb24ApplicationTests.testingQueries