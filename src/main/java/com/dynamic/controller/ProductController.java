package com.dynamic.controller;

import com.dynamic.dto.ProductDto;
import com.dynamic.dto.UserDto;
import com.dynamic.entity.Product;
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
    public ResponseEntity getProducts(){
        try{
            List<ProductDto> productDtoList = productService.getProducts();
            return new ResponseEntity<>(productDtoList, null, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Error on getting the list of products", null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity saveProduct(@RequestBody ProductDto newProductDto){
        try{
            Product savedProduct = productService.createProduct(ProductMapper.toProduct(newProductDto));
            ProductDto savedProductDtoToResponse = ProductMapper.toDto(savedProduct);
            return new ResponseEntity<>(savedProductDtoToResponse, null, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Error on creating product", null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateProduct(@PathVariable Integer id, @RequestBody ProductDto updatedProductDto){
        try{
            Product existingProduct = productService.findProductById(id);
            if(existingProduct != null){
                updatedProductDto.setId(id);
                Product updatedProduct = productService.updateProduct(ProductMapper.toProduct(updatedProductDto));
                ProductDto updatedProductDtoToResponse = ProductMapper.toDto(updatedProduct);
                return new ResponseEntity<>(updatedProductDtoToResponse, null, HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>("Product not found", null, HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            return new ResponseEntity<>("Error on updating product", null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}/{quantity}")
    public ResponseEntity getProductAvailability(@PathVariable("id") Integer id, @PathVariable("quantity") Integer quantity){
        try{
            boolean productIsAvailable = productService.getProductAvailability(id, quantity);
            return new ResponseEntity<>(productIsAvailable, null, HttpStatus.OK) ;
        }catch (Exception e){
            return new ResponseEntity<>("Error on checking the product availability", null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
