package com.shinetechchina.base.entity;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User extends AbstractPersistable<Long> {

	private static final long serialVersionUID = 109776503664659259L;

	@Setter
	@Getter
	@NotEmpty
	private String username;

	@Setter
	@Getter
	@NotEmpty
	private String password;

	@Setter
	@Getter	
	private String salt;
	
	@Setter
	@Getter
	@NotEmpty
	private boolean accountNonExpired;
	
	@Setter
	@Getter
	@NotEmpty
	private boolean accountNonLocked;
	
	@Setter
	@Getter
	@NotEmpty
	private boolean credentialsNonExpired;
	
	@Setter
	@Getter
	@NotEmpty
	private boolean enabled;

	@Setter
	@Getter
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "role_id") })
	private Set<Role> roles = new HashSet<Role>();

	public User(User user) {
		super();
		this.setId(user.getId());
		this.setUsername(user.getUsername());
		this.setPassword(user.getPassword());
		this.setSalt(user.getSalt());
		this.setRoles(user.getRoles());
		this.setAccountNonExpired(user.isAccountNonExpired());
		this.setAccountNonLocked(user.isAccountNonLocked());
		this.setCredentialsNonExpired(user.isCredentialsNonExpired());
		this.setEnabled(user.isEnabled());
	}
}
