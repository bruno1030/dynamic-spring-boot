package com.dynamic.controller;

import com.dynamic.dto.ProductDto;
import com.dynamic.mapper.ProductMapper;
import com.dynamic.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public List<ProductDto> getProducts(){
        List<ProductDto> productDtoList = productService.GetProducts();
        return productDtoList;
    }

    @PostMapping
    public ResponseEntity saveProduct(@RequestBody ProductDto productDto){

        try{
            productService.CreateProduct(ProductMapper.toProduct(productDto));
            return new ResponseEntity<>(null, null, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Error on creating product", null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
