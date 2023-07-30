package com.example.projectbase.controller;

import com.example.projectbase.domain.dto.request.ProductDetailCreateDTO;
import com.example.projectbase.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product_detail")
public class ProductDetailController {
    @Autowired
    private ProductDetailService productDetailService;
    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody ProductDetailCreateDTO productDetailCreateDTO){
        return ResponseEntity.ok(productDetailService.create(productDetailCreateDTO));
    }
}
