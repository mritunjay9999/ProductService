package dev.mritunjay.productservicettsmrngfeb24.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequestDto {

//    private Long id;
    private String title;
    private String image;
    private String description;
    private String category;
    private double price;
//    private Long userId;
}

//Dto for each request so that in future , if request needs additional parameters
// then you can easily add without impacting anything
