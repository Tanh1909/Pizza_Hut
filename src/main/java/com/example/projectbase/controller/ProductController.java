package com.example.projectbase.controller;

import com.example.projectbase.domain.dto.request.ProductCreateDTO;
import com.example.projectbase.domain.dto.request.ProductSearchPizzaDTO;
import com.example.projectbase.domain.dto.response.ProductResponseDTO;
import com.example.projectbase.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

//@RestApiV1
//@RestController("api/v1")
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    public ResponseEntity<?> newProduct(@Valid ProductCreateDTO productCreateDTO, BindingResult bindingResult){
        return ResponseEntity.ok(productService.createProduct(productCreateDTO, bindingResult));
    }

    @PutMapping
    public ResponseEntity<?> updateProduct(@Valid ProductCreateDTO productCreateDTO, BindingResult bindingResult){
        return ResponseEntity.ok(productService.updateProduct(productCreateDTO, bindingResult));
    }


    @GetMapping()
    public ResponseEntity<?> findProduct(ProductSearchPizzaDTO productSearchPizzaDTO){
//        List<ProductResponseDTO> productResponseDTOList = productService.findWithPizza(productSearchPizzaDTO);
        return ResponseEntity.ok(productService.findWithPizza(productSearchPizzaDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id){
        return null;
    }

    @GetMapping("/point")
    public ResponseEntity<?> productHavePoint(){
        return ResponseEntity.ok(productService.findProductHavePoint());
    }
}
