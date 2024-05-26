package com.example.ProductService.Models;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonPropertyOrder({"id", "title", "price", "category", "description", "image"})
@Entity
public class Product extends BaseClass {


    private String Title;
    private int price;
    @ManyToOne
    private Category category ;
    private String description;

    private String image;



}
