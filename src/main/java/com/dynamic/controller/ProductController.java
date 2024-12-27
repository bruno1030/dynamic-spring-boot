package com.dynamic.controller;

import com.dynamic.dto.ProductDto;
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
    public List<ProductDto> getProducts(){
        List<ProductDto> productDtoList = productService.getProducts();
        return productDtoList;
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

}
