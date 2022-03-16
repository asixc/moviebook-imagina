package com.moviebook.dto;

import com.moviebook.domain.Role;
import com.moviebook.entities.Film;
import com.moviebook.entities.RegistrationInformation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String email;
    private String nickname;
    private String firstName;
    private String lasName;
    private LocalDateTime lastUpdated;
    private boolean activated = false;
    private Role rol;
    private List<Film> films = new ArrayList<>();
    private RegistrationInformation registrationInformation;
}
