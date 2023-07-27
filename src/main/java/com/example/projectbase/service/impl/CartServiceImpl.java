package com.example.projectbase.service.impl;

import com.example.projectbase.converter.CartConvertDTO;
import com.example.projectbase.domain.dto.response.CartResponseDTO;
import com.example.projectbase.repository.CartRepository;
import com.example.projectbase.service.CartService;
import com.example.projectbase.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CartConvertDTO cartConvertDTO;
    @Autowired UserService userService;

    @Override
    public CartResponseDTO findCart() {
        return cartConvertDTO.convertEntityToDTO(userService.getCurrentUser().getCartEntity());
    }
}
