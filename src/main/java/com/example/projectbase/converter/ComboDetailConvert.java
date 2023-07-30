package com.example.projectbase.converter;

import com.example.projectbase.domain.dto.request.ComboDetailCreateDTO;
import com.example.projectbase.domain.dto.response.ComboDetailResposeDTO;
import com.example.projectbase.domain.entity.ComboDetailEntity;
import org.springframework.stereotype.Component;

@Component
public class ComboDetailConvert {


    public ComboDetailEntity convertDTOToEntity(ComboDetailCreateDTO comboDetailCreateDTO){
        ComboDetailEntity comboDetailEntity=new ComboDetailEntity();
        return comboDetailEntity;
    }
    public ComboDetailResposeDTO convertEntityToDTO(ComboDetailEntity comboDetailEntity){
        ComboDetailResposeDTO comboDetailResposeDTO=new ComboDetailResposeDTO();
        comboDetailEntity.setId(comboDetailEntity.getId());
        comboDetailResposeDTO.setComboName(comboDetailEntity.getComboEntity().getName());
        comboDetailResposeDTO.setProductName(comboDetailEntity.getProductDetailEntity().getProductEntity().getName());
        return comboDetailResposeDTO;
    }
}
