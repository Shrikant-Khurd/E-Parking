package com.epark.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Users implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Column(nullable = false, length = 45)
	private String email;

	@Column(nullable = false, length = 64)
	private String password;

	@Column(nullable = false, length = 20)
	private String userName;

	@Column(nullable = false)
	private long mobileNo;

	@Column(nullable = false, length = 64)
	private String address;

	@Column(nullable = false, length = 20)
	private String state;

	@Column(nullable = false, length = 20)
	private String city;

	@Column(nullable = false)
	private long pinCode;

	@Column(name = "account_status")
	private boolean accountStatus;

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })

	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "roleId"))
//	  @JsonIgnore 
	// private List<UserRole> userRoles=new ArrayList<UserRole>();
	private Set<UserRole> userRole; // = new HashSet<UserRole>();

//	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })
//	@JsonIgnoreProperties(value = { "Users", "hibernateLazyInitializer" })
//	@JoinColumn(name = "roleId")
//	private UserRole userRole;


}
