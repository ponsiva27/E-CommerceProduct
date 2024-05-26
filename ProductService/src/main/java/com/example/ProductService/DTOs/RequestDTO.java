package com.example.ProductService.DTOs;

import com.example.ProductService.Models.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestDTO {

    private long id;
    private String Title;
    private int price;
    private String description;
    private String category ;
    private String image;


}
