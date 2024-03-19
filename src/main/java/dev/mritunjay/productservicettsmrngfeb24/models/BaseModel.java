package dev.mritunjay.productservicettsmrngfeb24.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    When used AUTO instead of IDENTITY , FlyWay showed Schema-validation error.
//    AUTO: The choice of generation strategy is delegated to the JPA provider. It may use identity columns, sequences, or other methods based on the database.
//    IDENTITY: The primary key value is generated by the database itself, usually using auto-increment columns. This strategy is often database-specific.

    private Long id;
    private Date createdAt;
    private Date lastUpdatedAt;
    private boolean isDeleted;

//    public Date getCreatedAt(){
//        return createdAt;
//    }
}
