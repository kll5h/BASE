package com.shinetechchina.base.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Role extends AbstractPersistable<Long> implements GrantedAuthority {

	private static final long serialVersionUID = -4280778545959784213L;

	@Setter
	@Getter
	@NotEmpty
	private String name;

	@RestResource(exported = false)
	@Setter
	@Getter
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
	private Set<User> users = new HashSet<User>();

	@Override
	public String getAuthority() {
		return "ROLE_" + name;
	}
}
