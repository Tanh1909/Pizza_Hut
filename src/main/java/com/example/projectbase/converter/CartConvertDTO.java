package com.example.projectbase.converter;

import com.example.projectbase.domain.dto.response.CartResponseDTO;
import com.example.projectbase.domain.entity.CartEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class CartConvertDTO {
    public CartResponseDTO convertEntityToDTO(CartEntity cartEntity){
        CartResponseDTO cartResponseDTO=new CartResponseDTO();
        return cartResponseDTO;
    }
}
