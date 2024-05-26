package com.example.ProductService.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/products")
public class TestController {

    @GetMapping("/welcome")
    public void welcome(){
        System.out.print("Welcome Ponsiva");
    }

    @GetMapping("/add")
    public String add() throws InterruptedException {
        Thread.sleep(10000);

        return String.valueOf(7+7);

    }

    @GetMapping("/city/{Ponsiva}/{Chennai}")
    public String city(@PathVariable ("Ponsiva") String name,  @PathVariable ("Chennai") String city ){
         return  "your name is"+ name +" "+ "your city is"+ city;
    }


}
