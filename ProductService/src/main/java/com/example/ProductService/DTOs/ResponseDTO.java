package com.example.ProductService.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDTO {

    private long id;
    private String Title;
    private int price;
    private String description;
    private String category;
    private String image;

}
