package com.example.ProductService.Controller;


import com.example.ProductService.DTOs.RequestDTO;
import com.example.ProductService.Models.Category;
import com.example.ProductService.Models.Product;
import com.example.ProductService.Service.FakeStoreServices;
import com.example.ProductService.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("")
public class ProductController {

    FakeStoreServices fakeStoreServices;

    @Autowired
    public ProductController(FakeStoreServices fakeStoreServices){
        
        this.fakeStoreServices =fakeStoreServices;
    }

    
    @GetMapping("/products")
    public List getAllProducts(){

        return fakeStoreServices.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product getSingleProduct(@PathVariable ("id") long id){
        
        return fakeStoreServices.getSingleProduct(id);
    }


    @GetMapping("/products/categories")
    public List<Category> getCategory(){
            return  new ArrayList<>();
    }


    @GetMapping("/products/category/{catName}")
    public List<Product> getProductsFromCategory(@PathVariable ("catName") String categoryName){
            return  new ArrayList<>();
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody RequestDTO requestDTO){

        return null;
    }

    @PatchMapping("/products/{id}")
    public Product updateProduct (@PathVariable ("id") long id, @RequestBody RequestDTO requestDTO){

         return fakeStoreServices.updateProduct(id, requestDTO);
    }

    @PutMapping("/products/{id}")
    public  Product replaceProduct (@PathVariable("id") long id, @RequestBody RequestDTO requestDTO){

        if(requestDTO.getTitle()==null || requestDTO.getImage()==null
                || requestDTO.getDescription()==null){
            return  null;
        }

        return  fakeStoreServices.replaceProduct(id, requestDTO);
    }

    @DeleteMapping("/products/{id}")
    public boolean deleteProduct(@PathVariable("id") long id){
         return  true;
    }
}
