package com.example.ProductService.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Category extends  BaseClass {

    private String name;

}
