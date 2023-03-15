package com.epark.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.epark.model.UserRole;
import com.epark.model.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {

	
//	@Query("SELECT u FROM Users u WHERE u.email = ?1")
	//public Users findByUserId(long id);

	//@Query("SELECT u FROM Users u WHERE u.password =?1 ")
	public Users findByPassword(String password);
	
	public Users findUserById(long id);

	//@Query("SELECT u FROM Users u WHERE u.verificationCode = ?1")
	//public Users findByVerificationCode(String code);
	
	//@Query("SELECT u FROM Users u WHERE u.accountStatus = ?1")
	//public Users findByaccountStatus(Boolean status);

	@Query(value="SELECT * FROM users  WHERE role_id = ?1",nativeQuery=true )
	public List<Users> findUsersByUsersRole(int roleId);
	
	@Query(value="select id, user_name, address, password, email,city,mobile_no,pin_code,state,account_status, user_roles.role_id, role.role_name from users\r\n" + 
			"join user_roles on users.id= user_roles.user_id\r\n" + 
			"join role on role.role_id=user_roles.role_id where user_roles.user_id=?1", nativeQuery=true)
	public Users findByUserRoleId(long id);
	
}
