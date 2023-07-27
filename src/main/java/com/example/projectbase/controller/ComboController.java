package com.example.projectbase.controller;

import com.example.projectbase.domain.dto.request.ComboCreateDTO;
import com.example.projectbase.domain.dto.request.ComboDetailCreateDTO;
import com.example.projectbase.service.ComboDetailService;
import com.example.projectbase.service.ComboService;
import com.example.projectbase.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/combo")
public class ComboController {
    @Autowired
    private ComboService comboService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ComboDetailService comboDetailService;
    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @ModelAttribute ComboCreateDTO comboCreateDTO){
        return ResponseEntity.ok(comboService.createCombo(comboCreateDTO));
    }
    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(comboService.findAll());
    }
    @GetMapping("/findByCategory/{category_id}")
    public ResponseEntity<?> findByCategoryId(@PathVariable Long category_id){
        return ResponseEntity.ok(comboService.findByCategoryId(category_id));
    }
    @GetMapping("/findByCombo")
    public ResponseEntity<?> findByCombo(@RequestParam Long comboId,@RequestParam Long categoryId){
        return ResponseEntity.ok(productService.findByCombo(comboId,categoryId));
    }
    @PostMapping("/addProduct")
    public ResponseEntity<?> addProduct(@RequestBody ComboDetailCreateDTO comboDetailCreateDTO){
        return ResponseEntity.ok(comboDetailService.create(comboDetailCreateDTO));
    }
    @GetMapping("/findByComboId/{id}")
    public ResponseEntity<?> findByComboId(@PathVariable Long id){
        return ResponseEntity.ok(comboDetailService.findByComboId(id));
    }

}
