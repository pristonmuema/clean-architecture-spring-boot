package com.pristonit.cleanarchetecture.domain.users;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "Privileges")
public class Privilege {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	@Column(nullable = false, unique = true)
	String functionality;

	@ManyToMany(mappedBy = "privileges")
	List<User> users;
	public Privilege() {
	}

	public Privilege(String functionality) {
		this.functionality = functionality;
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
}
