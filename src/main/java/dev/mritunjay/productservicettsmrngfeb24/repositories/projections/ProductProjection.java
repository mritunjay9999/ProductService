package dev.mritunjay.productservicettsmrngfeb24.repositories.projections;


// A superset Projection interface is made so that it can be called anywhere with any no. of parameters, making our project scalable
public interface ProductProjection {
    Long getId();
    String getTitle();
    String getDescription();
    String getImage();

    String getCategory();
    double getPrice();

}
