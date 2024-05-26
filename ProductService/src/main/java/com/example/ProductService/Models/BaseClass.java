package com.example.ProductService.Models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class BaseClass {

    @Id
    private long id;
    private int CreatedAt;
    private int lastUpdatedAt;
    private boolean isDeleted;

}
