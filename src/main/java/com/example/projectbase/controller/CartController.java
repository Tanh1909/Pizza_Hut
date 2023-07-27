package com.example.projectbase.controller;

import com.example.projectbase.domain.dto.request.CartCreateDTO;
import com.example.projectbase.service.CartService;
import com.example.projectbase.service.ComboDetailService;
import com.example.projectbase.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartService cartService;
    @Autowired
    ComboDetailService comboDetailService;
    @Autowired
    ProductDetailService productDetailService;
    @GetMapping("")
    public ResponseEntity<?> create(){
        return ResponseEntity.ok(cartService.findCart());
    }
    @PostMapping("/addProduct/{id}")
    public ResponseEntity<?> addProduct(@PathVariable Long id){

        return ResponseEntity.ok(productDetailService.addToCart(id));
    }
    @PostMapping("/addCombo/{id}")
    public ResponseEntity<?> addCombo(@PathVariable Long id){
        return ResponseEntity.ok(comboDetailService.addToCart(id));
    }
}
