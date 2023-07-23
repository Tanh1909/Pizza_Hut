package com.example.projectbase.service.impl;

import com.example.projectbase.constant.ErrorMessage;
import com.example.projectbase.constant.SortByDataConstant;
import com.example.projectbase.converter.UserConverter;
import com.example.projectbase.domain.dto.pagination.PaginationFullRequestDto;
import com.example.projectbase.domain.dto.pagination.PaginationResponseDto;
import com.example.projectbase.domain.dto.request.UserRequestDTO;
import com.example.projectbase.domain.dto.response.UserDto;
import com.example.projectbase.domain.entity.RoleEntity;
import com.example.projectbase.domain.entity.UserEntity;
//import com.example.projectbase.domain.mapper.UserMapper;
import com.example.projectbase.email.MailService;
import com.example.projectbase.exception.AlreadyExistsException;
import com.example.projectbase.exception.NotFoundException;
import com.example.projectbase.repository.RoleRepository;
import com.example.projectbase.repository.UserRepository;
import com.example.projectbase.security.UserPrincipal;
import com.example.projectbase.service.UserService;
import com.example.projectbase.util.BindingResultUtils;
import com.example.projectbase.util.PaginationUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import javax.validation.Valid;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  private final UserConverter userConverter;

//  private final UserMapper userMapper;

  private final MailService mailService;

  private final PasswordEncoder passwordEncoder;

  private final RoleRepository roleRepository;

  @Value("${spring.mail.username}")
  private String gmail;

  public UserServiceImpl(UserRepository userRepository, UserConverter userConverter, MailService mailService, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
    this.userRepository = userRepository;
    this.userConverter = userConverter;
    this.mailService = mailService;
    this.passwordEncoder = passwordEncoder;
    this.roleRepository = roleRepository;
  }

  @Override
  public UserDto getUserById(String userId) {
    UserEntity userEntity = userRepository.findById(userId)
        .orElseThrow(() -> new NotFoundException(ErrorMessage.User.ERR_NOT_FOUND_ID, new String[]{userId}));
    return userConverter.converEntityToResponseDTO(userEntity);
  }

  @Override
  public PaginationResponseDto<UserDto> getCustomers(PaginationFullRequestDto request) {
    //Pagination
    Pageable pageable = PaginationUtil.buildPageable(request, SortByDataConstant.USER);
    //Create Output
    return new PaginationResponseDto<>(null, null);
  }

  @Override
  public UserDto getCurrentUser(UserPrincipal principal) {
    UserEntity userEntity = userRepository.getUser(principal);
    return userConverter.converEntityToResponseDTO(userEntity);
  }


  @Override
  public ResponseEntity<?> createNewUser(@Valid UserRequestDTO userDTO,
                                         BindingResult bindingResult) {
    BindingResultUtils.bindResult(bindingResult);
    Optional<UserEntity> userUserName = userRepository.findByUsername(userDTO.getUsername());
    if(userUserName.isPresent() ){
      throw new AlreadyExistsException("User already exists with username " + userDTO.getUsername());
    }
    UserEntity userEntity = userRepository.findByEmail(userDTO.getEmail());
    if(userEntity != null) {
      throw new AlreadyExistsException("User already exists with username " + userDTO.getEmail());
    }
    userEntity = userRepository.findByPhone(userDTO.getPhoneNumber());
    if(userEntity != null){
      throw new AlreadyExistsException("User already exists with phone " + userDTO.getPhoneNumber());
    }
    UserEntity userEntitySave = userConverter.converDTOToEntity(userDTO);
    RoleEntity role = roleRepository.findByRoleName("ROLE_USER");
    userEntitySave.setRoleEntity(role);
    return ResponseEntity.ok(userConverter.converEntityToDTO(userRepository.save(userEntitySave)));
  }
}
