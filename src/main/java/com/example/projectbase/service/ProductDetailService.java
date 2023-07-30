package com.example.projectbase.service;

import com.example.projectbase.domain.dto.request.ProductDetailCreateDTO;
import com.example.projectbase.domain.dto.response.ProductDetailResponseDTO;

public interface ProductDetailService {
     ProductDetailResponseDTO create(ProductDetailCreateDTO productDetailCreateDTO);
    ProductDetailResponseDTO addToCart(Long id);
    void deleteById(Long id);
}
