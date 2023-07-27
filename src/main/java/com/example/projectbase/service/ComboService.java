package com.example.projectbase.service;

import com.example.projectbase.domain.dto.request.ComboCreateDTO;
import com.example.projectbase.domain.dto.response.ComboResponseDTO;
import com.example.projectbase.domain.entity.ProductDetailEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import javax.validation.Valid;
import java.util.List;

public interface ComboService {
    ComboResponseDTO createCombo( ComboCreateDTO comboCreateDTO);
    ComboResponseDTO findOne(Long id);
    List<ComboResponseDTO> findAll();
    void deleteCombo(Long id);
    List<ComboResponseDTO> findByCategoryId(Long category_id);


}
