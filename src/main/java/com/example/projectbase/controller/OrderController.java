package com.example.projectbase.controller;

import com.example.projectbase.domain.dto.request.ComboCreateDTO;
import com.example.projectbase.domain.dto.request.OrderCreateDTO;
import com.example.projectbase.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody OrderCreateDTO orderCreateDTO){
        return ResponseEntity.ok(orderService.create(orderCreateDTO));
    }
    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(orderService.findAll());
    }
}
