package dev.mritunjay.productservicettsmrngfeb24;

import dev.mritunjay.productservicettsmrngfeb24.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Productservicettsmrngfeb24ApplicationTests {

//    To put a Spring bean in test case we need to annotate the bean with autowired
    @Autowired
    private ProductRepository productRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testingQueries()
    {
//        productRepository.findByIdIs(102L);
//        productRepository.findAllByTitle("Hello");
//          productRepository.findFirstByIdIs(2L);

    }

}
