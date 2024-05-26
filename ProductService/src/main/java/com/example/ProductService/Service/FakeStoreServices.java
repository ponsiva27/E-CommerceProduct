package com.example.ProductService.Service;

import com.example.ProductService.DTOs.RequestDTO;
import com.example.ProductService.Models.Product;

import java.util.List;

public interface FakeStoreServices {

    public Product getSingleProduct(long id);

    public List<Product> getAllProducts();

    public Product replaceProduct(long id, RequestDTO requestDTO);

    public Product updateProduct(long id, RequestDTO requestDTO);
}
