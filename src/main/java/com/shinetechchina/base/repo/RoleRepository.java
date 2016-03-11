package com.shinetechchina.base.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.security.access.prepost.PreAuthorize;

import com.shinetechchina.base.entity.Role;

@PreAuthorize("hasRole('USER')")
public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {

}
