package com.example.projectbase.domain.dto.response;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Getter
@Setter
public class UserResponseDTO {
    private Long id;
    private String fullName;
    private String accessToken;
    private String refreshToken;
    private Collection<? extends GrantedAuthority> authorities;

    public UserResponseDTO() {
    }

    public UserResponseDTO(Long id, String fullName, String accessToken, String refreshToken, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.fullName = fullName;
        this.accessToken = accessToken;
        this.authorities = authorities;
        this.refreshToken = refreshToken;
    }

}
