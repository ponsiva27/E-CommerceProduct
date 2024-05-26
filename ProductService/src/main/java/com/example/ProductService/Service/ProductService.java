package com.example.ProductService.Service;

import com.example.ProductService.DTOs.RequestDTO;
import com.example.ProductService.DTOs.ResponseDTO;
import com.example.ProductService.Models.Category;
import com.example.ProductService.Models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements  FakeStoreServices {

    RestTemplate restTemplate;

    @Autowired
    public ProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(long id) {

        //hit the third Party API to get the response.
        //parse the Json response  to proper object format (product) and return to controller.
        ResponseDTO responseDTO = restTemplate.getForObject
                ("https://fakestoreapi.com/products/" + id, ResponseDTO.class);

        Product product = getProductFromResponseDTO(responseDTO);

        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        ResponseDTO[] responseDTO = restTemplate.getForObject("https://fakestoreapi.com/products", ResponseDTO[].class);

        ArrayList<Product>  allProduct  = new ArrayList<>();

        for(ResponseDTO response : responseDTO){
            allProduct.add(getProductFromResponseDTO(response));
        }

        return allProduct;
    }

    @Override  //put the requestDTO to update the product and get back the response
    public Product replaceProduct(long id, RequestDTO requestDTO){


       /* // Execute PUT request with the updated product details
        ResponseEntity<ResponseDTO> responseEntity = restTemplate.exchange(
                "https://fakestoreapi.com/products/" + id,
                HttpMethod.PUT,
                new HttpEntity<>(requestDTO), // Send the updated product details as request body
                ResponseDTO.class
        );

        // Extract the updated product details from the response
        ResponseDTO responseDTO = responseEntity.getBody();
        if (responseDTO == null) {
            return null; // Handle null response as needed
        }*/

        // Convert the ResponseDTO to Product and return
     

       RequestCallback requestCallback = restTemplate.httpEntityCallback(requestDTO, ResponseDTO.class);
       HttpMessageConverterExtractor<ResponseDTO> responseExtractor = new HttpMessageConverterExtractor
                                                                    (ResponseDTO.class, restTemplate.getMessageConverters());
       ResponseDTO responseDTO =  restTemplate.execute("https://fakestoreapi.com/products/" + id, HttpMethod.PUT, requestCallback, responseExtractor);

        return getProductFromResponseDTO(responseDTO);
        
       //ResponseDTO responseDTO = restTemplate.put("'https://fakestoreapi.com/products/"+ id ,);

    
    }

    @Override
    public  Product updateProduct(long id, RequestDTO requestDTO){

        RequestCallback requestCallback = restTemplate.httpEntityCallback(requestDTO, ResponseDTO.class);
        HttpMessageConverterExtractor<ResponseDTO> responseExtractor = new HttpMessageConverterExtractor
                (ResponseDTO.class, restTemplate.getMessageConverters());

       ResponseDTO responseDTO =  restTemplate.execute(
                "https://fakestoreapi.com/products/" + id,
                HttpMethod.PUT,
                requestCallback,
                responseExtractor);

       return getProductFromResponseDTO(responseDTO);
    }

    private Product getProductFromResponseDTO(ResponseDTO responseDTO){
        Product product = new Product();
        product.setId(responseDTO.getId());
        product.setTitle(responseDTO.getTitle());
        product.setDescription(responseDTO.getDescription());
        product.setImage(responseDTO.getImage());
        product.setPrice(responseDTO.getPrice());

        // create a category object and set it's name to the responseDTO
        Category category = new Category();
        category.setName(responseDTO.getCategory());
        product.setCategory(category);
        // (or)

        //product.setCategory(new category());
       //  product.getCategory().setName(responseDTO.getCategory());

        return  product;

    }

}
