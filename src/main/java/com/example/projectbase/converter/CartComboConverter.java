package com.example.projectbase.converter;

import com.example.projectbase.domain.dto.response.ComboCartDTO;
import com.example.projectbase.domain.entity.ComboDetailEntity;
import com.example.projectbase.repository.ComboDetailRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Component
public class CartComboConverter {
    @Autowired
    ComboDetailRepository comboDetailRepository;
    @Autowired
    ProductDetailConverter productDetailConverter;
    public ComboCartDTO convertEntityToDTO(ComboDetailEntity comboDetailEntity){
        ComboCartDTO comboCartDTO=new ComboCartDTO();
        comboCartDTO.setId(comboDetailEntity.getId());
        comboCartDTO.setName(comboDetailEntity.getComboEntity().getName());
        comboCartDTO.setPrice(comboDetailEntity.getPrice());
        List<ComboDetailEntity> list=comboDetailRepository.findByComboId(comboDetailEntity.getComboEntity().getId());
        for(ComboDetailEntity x:list){
            comboCartDTO.getProductDetailResponseDTOS().add(productDetailConverter.convertEntityToDTO(x.getProductDetailEntity()));
        }
        return comboCartDTO;
    }
    public List<ComboCartDTO> convertListEntityToListDTO(List<ComboDetailEntity> comboDetailEntities){
        List<ComboCartDTO> cartDTOList=new ArrayList<>();
        for(ComboDetailEntity x:comboDetailEntities){
            cartDTOList.add(convertEntityToDTO(x));
        }
        return cartDTOList;
    }
}
