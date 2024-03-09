package dev.mritunjay.productservicettsmrngfeb24.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Got this functionality from Lombok library otherwise using command+n getter-setter used
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product extends BaseModel{

    private String title;
    private String description;
    private double price;
    private String imageUrl;

    @ManyToOne(cascade = {CascadeType.PERSIST})
//    if a product is removed then mapped category will persist in db
//    @ManyToOne
    private Category category;



}
