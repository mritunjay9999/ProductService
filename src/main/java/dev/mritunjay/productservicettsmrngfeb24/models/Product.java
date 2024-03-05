package dev.mritunjay.productservicettsmrngfeb24.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Got this functionality from Lombok library otherwise using command+n getter-setter used
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private Long id;
    private String title;
    private String description;
    private double price;
    private String imageUrl;
    private Category category;



}
