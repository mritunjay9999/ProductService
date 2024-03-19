package dev.mritunjay.productservicettsmrngfeb24;

import dev.mritunjay.productservicettsmrngfeb24.models.Category;
import dev.mritunjay.productservicettsmrngfeb24.models.Product;
import dev.mritunjay.productservicettsmrngfeb24.repositories.CategoryRepository;
import dev.mritunjay.productservicettsmrngfeb24.repositories.ProductRepository;
import dev.mritunjay.productservicettsmrngfeb24.repositories.projections.ProductProjection;
import dev.mritunjay.productservicettsmrngfeb24.repositories.projections.ProductWithTitleAndId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

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

        Optional<Category> optionalCategory = categoryRepository.findById(202L);
        Category category = optionalCategory.get();
//      No join statement by hibernate till now i.e. LAZY LOADING

        System.out.println("Fetched the category object");
//        Optional<> class got added in java 1.8 to avoid NullPointerException (using this, many if-else blocks are eliminated)
//        Using its methods like isPresent() , orElse() etc. makes coding easy and simple.

//        List<Product> products = optionalCategory.get().getProducts();
//        Not required with EAGER LOADING
        System.out.println("Successfully Fetched list of products from Category object");
//        Got 2 products from Category id 202L
    }

}

//Productservicettsmrngfeb24ApplicationTests.testingQueries