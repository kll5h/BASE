package com.shinetechchina.base.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;

import com.shinetechchina.base.entity.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

	@PreAuthorize("hasRole('ADMIN')")
	@Override
	Iterable<User> findAll();
	
	@PreAuthorize("hasRole('ADMIN')")
	@Override
	Iterable<User> findAll(Sort sort);

	@PreAuthorize("hasRole('ADMIN')")
	@Override
	Page<User> findAll(Pageable pageable);
	
	@PreAuthorize("hasRole('ADMIN')")
	@Override
	Iterable<User> findAll(Iterable<Long> ids);
	
	@PreAuthorize("hasRole('ADMIN')")
	@Override
	long count();
	
	@PostAuthorize("returnObject.id == principal.id or hasRole('ADMIN')")
	@Override
	User findOne(Long id);
	
	@PreAuthorize("hasRole('ADMIN')")
	@Override
	boolean exists(Long id);
	
	@PreAuthorize("hasRole('ADMIN')")
	@Override
	<S extends User> S save(S entity);

	@RestResource(exported = false)
	@Override
	<S extends User> Iterable<S> save(Iterable<S> entities);
	
	@PreAuthorize("hasRole('ADMIN')")
	@Override
	void delete(Long id);

	@PreAuthorize("hasRole('ADMIN')")
	@Override
	void delete(User entity);

	@RestResource(exported = false)
	@Override
	void delete(Iterable<? extends User> entities);

	@RestResource(exported = false)
	@Override
	void deleteAll();
	
	@RestResource(exported = false)
	User findByUsername(String username);

}
