package dev.mritunjay.productservicettsmrngfeb24.repositories;

import dev.mritunjay.productservicettsmrngfeb24.models.Category;
import dev.mritunjay.productservicettsmrngfeb24.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.PriorityQueue;

public interface ProductRepository extends JpaRepository<Product , Long> {
//        Dealing with Product class and data type of primary key is Long
        Product save(Product p);
//        Product that is passed as a parameter will not contain "id"
//        But returned Product will contain "id" parameter
//        So..the attributes which are automatically generated by DB will not in parameters
//        but will be there in the returned objects

        @Override
        List<Product> findAll();

        Product findByIdIs(Long id);

//        Product findAllByTitle(String title);
//        Product findFirstByIdIs(Long id);

        List<Product> findAllByCategory(Category category);


}

