package com.example.projectbase.converter;

import com.example.projectbase.domain.dto.request.ProductDetailCreateDTO;
import com.example.projectbase.domain.dto.response.ProductDetailResponseDTO;
import com.example.projectbase.domain.entity.ProductDetailEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ProductDetailConverter {

    public ProductDetailEntity convertDTOToEntity(ProductDetailCreateDTO productDetailCreateDTO){
        ProductDetailEntity productDetailEntity=new ProductDetailEntity();

        return productDetailEntity;
    }
    public ProductDetailResponseDTO convertEntityToDTO(ProductDetailEntity productDetailEntity){
        ProductDetailResponseDTO productDetailResponseDTO=new ProductDetailResponseDTO();
        productDetailResponseDTO.setPrice(productDetailEntity.getPrice());
        productDetailResponseDTO.setQuatity(productDetailEntity.getQuatity());
        productDetailResponseDTO.setId(productDetailEntity.getId());
        productDetailResponseDTO.setProductName(productDetailEntity.getProductEntity().getName());
        productDetailResponseDTO.setCakeBaseName(productDetailEntity.getCakeBaseEntity().getName());
        productDetailResponseDTO.setSizeName(productDetailEntity.getSizeEntity().getName());
        return productDetailResponseDTO;
    }
    public List<ProductDetailResponseDTO> convertListEntityToListDTO(List<ProductDetailEntity> productDetailEntities){
        List<ProductDetailResponseDTO> productDetailResponseDTOS=new ArrayList<>();
        for(ProductDetailEntity x:productDetailEntities){
            productDetailResponseDTOS.add(convertEntityToDTO(x));
        }
        return productDetailResponseDTOS;
    }
}
