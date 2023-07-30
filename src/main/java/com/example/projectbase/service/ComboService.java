package com.example.projectbase.service;

import com.example.projectbase.domain.dto.request.ComboCreateDTO;
import com.example.projectbase.domain.dto.response.ComboResponseDTO;

import java.util.List;

public interface ComboService {
    ComboResponseDTO create(ComboCreateDTO comboCreateDTO);
    List<ComboResponseDTO> findByCategoryId(Long category_id);
}
