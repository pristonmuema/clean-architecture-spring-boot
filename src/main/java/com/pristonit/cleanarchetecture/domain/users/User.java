package com.pristonit.cleanarchetecture.domain.users;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import static com.pristonit.cleanarchetecture.infra.gateways.http.security.Security.ENCODER;


@Entity
@Table(name = "Users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	@Column(nullable = false)
	String firstName;
	@Column(nullable = false)
	String secondName;
	@Column(nullable = false, unique = true)
	String email;
	@Column(nullable = false)
	String password;
	String primaryPhoneNumber;
	String secondaryPhoneNumber;

	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE,
	                                                CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(
			name = "users_privileges",
			joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID")},
			inverseJoinColumns = {@JoinColumn(name = "PRIVILEGE_ID", referencedColumnName = "ID")}
	)
	List<Privilege> privileges = new ArrayList<>();
	@CreationTimestamp
	LocalDateTime createdAt;
	@UpdateTimestamp
	LocalDateTime updatedAt;


	public User() {
	}

	public User(String firstName, String secondName, String email, String password,
	            String primaryPhoneNumber, String secondaryPhoneNumber, List<Privilege> privileges) {
		this.firstName = firstName;
		this.secondName = secondName;
		this.email = email;
		this.password = encodePassword(password);
		this.primaryPhoneNumber = primaryPhoneNumber;
		this.secondaryPhoneNumber = secondaryPhoneNumber;
		this.privileges = privileges;
		this.createdAt = LocalDateTime.now();
		this.updatedAt = LocalDateTime.now();
	}

	private static String encodePassword(String password) {
		return ENCODER.encode(password);
	}

	public void updatePassword(String newPassword) {
		this.password = encodePassword(newPassword);
	}

	public Boolean validatePassword(String password) {
		return ENCODER.matches(password, this.password);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrimaryPhoneNumber() {
		return primaryPhoneNumber;
	}

	public void setPrimaryPhoneNumber(String primaryPhoneNumber) {
		this.primaryPhoneNumber = primaryPhoneNumber;
	}

	public String getSecondaryPhoneNumber() {
		return secondaryPhoneNumber;
	}

	public void setSecondaryPhoneNumber(String secondaryPhoneNumber) {
		this.secondaryPhoneNumber = secondaryPhoneNumber;
	}

	public List<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(
			List<Privilege> privileges) {
		this.privileges = privileges;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
}
