package com.example.projectbase.service.impl;

import com.example.projectbase.converter.CartComboConverter;
import com.example.projectbase.converter.CartConvertDTO;
import com.example.projectbase.converter.ProductDetailConverter;
import com.example.projectbase.domain.dto.response.CartResponseDTO;
import com.example.projectbase.domain.entity.CartEntity;
import com.example.projectbase.service.CartService;
import com.example.projectbase.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartConvertDTO cartConvertDTO;
    @Autowired UserService userService;
    @Autowired
    private CartComboConverter cartComboConverter;
    @Autowired
    private ProductDetailConverter productDetailConverter;
    @Override
    public CartResponseDTO findCart() {
        CartEntity cartEntity=userService.getCurrentUser().getCartEntity();
        CartResponseDTO cartResponseDTO= cartConvertDTO.convertEntityToDTO(cartEntity);
        cartResponseDTO.setProductDetailResponseDTOS(productDetailConverter.convertListEntityToListDTO(cartEntity.getProductDetailEntities()));
        cartResponseDTO.setComboCartDTOS(cartComboConverter.convertListEntityToListDTO(cartEntity.getComboDetailEntities()));
        return  cartResponseDTO;
    }
}
