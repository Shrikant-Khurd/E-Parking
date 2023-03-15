package com.epark.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "role")
public class UserRole {

	@Id
	@GeneratedValue
	private int roleId;

	@Column(nullable = false, length = 50)
	private String roleName;

//	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE },
//			mappedBy = "roles")
//
//	@JsonIgnore
//	private Set<Users> user;
//	  @OneToMany(mappedBy= "userRole")
//	  @JsonIgnore private List<Users> users;

}
