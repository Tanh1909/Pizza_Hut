package com.example.projectbase.service.impl;

import com.example.projectbase.converter.ProductDetailConverter;
import com.example.projectbase.domain.dto.request.ProductDetailCreateDTO;
import com.example.projectbase.domain.dto.response.ProductDetailResponseDTO;
import com.example.projectbase.domain.entity.ProductDetailEntity;
import com.example.projectbase.repository.CakeBaseRepository;
import com.example.projectbase.repository.ProductDetailRepository;
import com.example.projectbase.repository.ProductRepository;
import com.example.projectbase.repository.SizeRepository;
import com.example.projectbase.service.ProductDetailService;
import com.example.projectbase.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDetailServiceImpl implements ProductDetailService {
    @Autowired
    private ProductDetailRepository productDetailRepository;
    @Autowired
    private ProductDetailConverter productDetailConverter;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    SizeRepository sizeRepository;
    @Autowired
    CakeBaseRepository cakeBaseRepository;
    @Autowired
    private UserService userService;
    @Override
    public ProductDetailResponseDTO create(ProductDetailCreateDTO productDetailCreateDTO) {
        ProductDetailEntity productDetailEntity=productDetailConverter.convertDTOToEntity(productDetailCreateDTO);
        productDetailEntity.setProductEntity(productRepository.findById(productDetailCreateDTO.getProductId()).orElseThrow(() -> new NullPointerException("khong tim thay product")));
        productDetailEntity.setSizeEntity(sizeRepository.findById(productDetailCreateDTO.getSizeId()).orElseThrow(() -> new NullPointerException("khong tim thay size")));
        productDetailEntity.setCakeBaseEntity(cakeBaseRepository.findById(productDetailCreateDTO.getCakeBaseId()).orElseThrow(() -> new NullPointerException("khong tim thay cakebase")));
        productDetailEntity.setPrice(1L);
        return productDetailConverter.convertEntityToDTO(productDetailRepository.save(productDetailEntity));
    }

    @Override
    public ProductDetailResponseDTO addToCart(Long id) {
        ProductDetailEntity productDetailEntity=productDetailRepository.findById(id).get();
        productDetailEntity.setCartEntity(userService.getCurrentUser().getCartEntity());
        for(ProductDetailEntity x: userService.getCurrentUser().getCartEntity().getProductDetailEntities()){
            if(x.getId()==productDetailEntity.getId()){
               productDetailEntity.setQuatity(productDetailEntity.getQuatity()+1);
            }
        }
        return productDetailConverter.convertEntityToDTO(productDetailRepository.save(productDetailEntity));
    }


}
