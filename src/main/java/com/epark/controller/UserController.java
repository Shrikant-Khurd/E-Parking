package com.epark.controller;

import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epark.model.UserRole;
import com.epark.model.Users;
import com.epark.repository.UserRepository;
import com.epark.service.UserService;


@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public ResponseEntity<String> addUser(@RequestBody Users user) {

		userService.addUser(user);
		return new ResponseEntity<String>("User registered successfully.", HttpStatus.CREATED);
	}


	@GetMapping("/login/{id}/{password}")
	public ResponseEntity<Users> verifyLoginWithPassword(@PathVariable long id,
			@PathVariable String password) {
		Users login = userService.LoginWithPassword(id, password);
		return new ResponseEntity<Users>(login, HttpStatus.OK);
	}
	
	
	
	/*
	 * @GetMapping("/get-all-users") public ResponseEntity<List<Users>>
	 * getAllUsers() { List<Users> userList = userService.getAllUser(); return new
	 * ResponseEntity<List<Users>>(userList, HttpStatus.OK); }
	 * 
	 * @GetMapping("/all-customers") public ResponseEntity<List<Users>>
	 * getAllCustomer(String userRole) { List<Users> allUsers =
	 * userService.getAllCustomer(userRole); return new
	 * ResponseEntity<List<Users>>(allUsers, HttpStatus.OK); }
	 * 
	 * @GetMapping("/all-Parking-Service-Provider") public
	 * ResponseEntity<List<Users>> getAllParkingServiceProvider(String
	 * organizerRole) { List<Users> allOrganizers =
	 * userService.getAllParkingServiceProvider(organizerRole); return new
	 * ResponseEntity<List<Users>>(allOrganizers, HttpStatus.OK); }
	 * 
	 * @PostMapping("/add-Role") public ResponseEntity<String> addRole(@RequestBody
	 * UserRole roleBean) { String addRoleStatus = userService.addRole(roleBean);
	 * return new ResponseEntity<String>(addRoleStatus, HttpStatus.OK); }
	 */

	/*
	 * @GetMapping("/login/{email}/{password}") public ResponseEntity<ResponseAPI>
	 * verifyLoginWithPassword(@PathVariable String email,
	 * 
	 * @PathVariable String password) { ResponseAPI verifyLoginWithOTP =
	 * userService.verifyLoginWithPassword(email, password); return new
	 * ResponseEntity<ResponseAPI>(verifyLoginWithOTP, HttpStatus.OK); }
	 * 
	 * @GetMapping("/byemail/{email}") public ResponseEntity<Users>
	 * getByEmail(@PathVariable String email) { Users userss =
	 * userService.getUserByEmail(email); return new ResponseEntity<Users>(userss,
	 * HttpStatus.OK); }
	 * 
	 * @GetMapping("/user-login/{email}") public ResponseEntity<String>
	 * loginWithEmail(@PathVariable String email) throws
	 * UnsupportedEncodingException, MessagingException { String loginUserReponse =
	 * userService.loginUserByEmail(email); return new
	 * ResponseEntity<String>(loginUserReponse, HttpStatus.OK); }
	 * 
	 * @GetMapping("/verify-otp/{email}/{otp}") public ResponseEntity<ResponseAPI>
	 * verifyLoginWithOTP(@PathVariable String email, @PathVariable String otp) {
	 * ResponseAPI verifyLoginWithPassword = userService.verifyLoginWithOTP(email,
	 * otp); return new ResponseEntity<ResponseAPI>(verifyLoginWithPassword,
	 * HttpStatus.OK); }
	 * 
	 * @GetMapping("/changepassword/{id}/{oldPassword}/{newPassword}")
	 * ResponseEntity<String> changePassword(@PathVariable int id, @PathVariable
	 * String oldPassword,
	 * 
	 * @PathVariable String newPassword) {
	 * 
	 * Users user = userRepository.findById(id).get(); if
	 * (oldPassword.equals(user.getPassword())) { userService.changePassword(id,
	 * newPassword); return new
	 * ResponseEntity<String>("password update successfully", HttpStatus.CREATED); }
	 * else { throw new
	 * RecordNotFoundException("Invalid password. please enter valid password."); }
	 * }
	 */

}
