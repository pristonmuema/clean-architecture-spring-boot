package com.pristonit.cleanarchetecture.domain.users;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "Privileges")
public class Privilege {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	@Column(nullable = false, unique = true)
	String functionality;
	String description;
	@Enumerated(EnumType.STRING)
	RoleType roleType;
	@ManyToMany(mappedBy = "privileges")
	List<User> users;
	@Column(nullable = false)
	String createdBy;
	@CreationTimestamp
	LocalDateTime createdAt;
	@UpdateTimestamp
	LocalDateTime updatedAt;
	public Privilege() {
	}

	public Privilege(String functionality, String description, RoleType roleType, String createdBy) {
		this.functionality = functionality;
		this.roleType = roleType;
		this.createdBy = createdBy;
		this.description = description;
		this.createdAt = LocalDateTime.now();
		this.updatedAt = LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFunctionality() {
		return functionality;
	}

	public List<User> getUsers() {
		return users;
	}

	public RoleType getRoleType() {
		return roleType;
	}

	public String getDescription() {
		return description;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
}
