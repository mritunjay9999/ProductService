package dev.mritunjay.productservicettsmrngfeb24.repositories;

import dev.mritunjay.productservicettsmrngfeb24.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category , Long> {
//    Dealing with Category class and data type of primary key is Long

    Category findByTitle(String title);

    List<Category> findAll();
    Category save(Category category);

}
