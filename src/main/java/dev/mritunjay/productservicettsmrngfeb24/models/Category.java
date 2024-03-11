package dev.mritunjay.productservicettsmrngfeb24.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Category extends BaseModel{

    private String title;
    @OneToMany(mappedBy = "category" , cascade = {CascadeType.REMOVE})
//    if you remove a category then mapped products will also get deleted
//    @OneToMany
    @JsonIgnore
    private List<Product> products;
}
