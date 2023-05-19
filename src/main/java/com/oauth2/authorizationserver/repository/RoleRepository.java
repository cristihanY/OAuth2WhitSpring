package com.oauth2.authorizationserver.repository;

import com.oauth2.authorizationserver.entity.Role;
import com.oauth2.authorizationserver.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByRole(RoleName roleName);
}
