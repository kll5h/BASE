package com.shinetechchina.base.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import org.springframework.data.jpa.domain.AbstractAuditable;
import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Role extends AbstractAuditable<User, Long> implements GrantedAuthority {

	private static final long serialVersionUID = -4280778545959784213L;

	@Setter
	@Getter
	@NotEmpty
	private String name;

	@Setter
	@Getter
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
	private Set<User> users = new HashSet<User>();
	
	@Override
	public String getAuthority() {
		return "ROLE_" + name;
	}

	@Override
	@JsonIgnore
	public User getCreatedBy() {
		return super.getCreatedBy();
	}

	@Override
	@JsonIgnore
	public DateTime getCreatedDate() {
		return super.getCreatedDate();
	}

	@Override
	@JsonIgnore
	public User getLastModifiedBy() {
		return super.getLastModifiedBy();
	}

	@Override
	@JsonIgnore
	public DateTime getLastModifiedDate() {
		return super.getLastModifiedDate();
	}
	
}
