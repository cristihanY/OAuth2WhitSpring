package com.oauth2.authorizationserver.service;

import com.oauth2.authorizationserver.dto.CreateAppUserDto;
import com.oauth2.authorizationserver.dto.MessageDto;
import com.oauth2.authorizationserver.entity.AppUser;
import com.oauth2.authorizationserver.entity.Role;
import com.oauth2.authorizationserver.enums.RoleName;
import com.oauth2.authorizationserver.repository.AppUserRepository;
import com.oauth2.authorizationserver.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class AppUserService {
  private final AppUserRepository appUserRepository;
  private final RoleRepository repository;
  private final PasswordEncoder passwordEncoder;

  public MessageDto createUser(CreateAppUserDto dto){
      System.out.println();
      AppUser appUser = AppUser.builder()
              .username(dto.username())
              .password(passwordEncoder.encode(dto.password()))
              .build();
      Set<Role> roles = new HashSet<>();
        dto.roles().forEach( r -> {
            Role role = repository.findByRole(RoleName.valueOf(r))
                    .orElseThrow(() -> new RuntimeException("Role not found"));
            roles.add(role);
        });
        appUser.setRoles(roles);
        appUserRepository.save(appUser);
        return  new MessageDto("user "+ appUser.getUsername() + " saved");

  }

}
