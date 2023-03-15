package com.epark.service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epark.model.UserRole;
import com.epark.repository.RoleRespository;
import com.epark.model.Users;
import com.epark.repository.UserRepository;

@Service
public class UserService {

	
	private UserRepository userRepository;
	private RoleRespository roleRespository;

	@Autowired
	public UserService(UserRepository userRepository, RoleRespository roleRespository) {
		this.userRepository = userRepository;
		this.roleRespository = roleRespository;
	}

//	public Users getUserByEmail(String email) {
//		Users user = userRepository.findByEmail(email);
//		return user;
//	}




	public Users getUserByPassword(String password) {
		Users user = userRepository.findByPassword(password);
		return user;
	}

	public boolean addUser(Users user) {

		Random random = new Random();
		long userId = (long) (1020300000L + random.nextFloat() * 99999);

		user.setId(userId);
		user.setAccountStatus(true);

		Set<UserRole> usersRoles = new HashSet<UserRole>();
		for (UserRole role : user.getUserRole()) {
			UserRole usersRole = roleRespository.findByRoleId(role.getRoleId());
			usersRoles.add(usersRole);
		}
		user.setUserRole(usersRoles);

		userRepository.save(user);
		return true;
	}

	public List<Users> getAllCustomer(String userRole) {
		List<Users> allCustomer = userRepository.findUsersByUsersRole(2);
		return allCustomer;
	}

	public List<Users> getAllParkingServiceProvider(String userRole) {
		List<Users> allParkingServiceProvider = userRepository.findUsersByUsersRole(1);
		return allParkingServiceProvider;
	}

	public List<Users> getAllUser() {
		return userRepository.findAll();
	}

	public Users getUserById(int id) {
		return userRepository.findById(id).orElse(null);
	}

	public void updateUserDetail(int id, Users user) {
		Users updateUser = userRepository.findById(id).get();

		if (user.getUserName() != null)
			updateUser.setUserName(user.getUserName());

		if (user.getAddress() != null)
			updateUser.setAddress(user.getAddress());

		if (user.getCity() != null)
			updateUser.setCity(user.getCity());

		if (user.getState() != null)
			updateUser.setState(user.getState());

		if (user.getPinCode() != 0)
			updateUser.setPinCode(user.getPinCode());
		userRepository.save(updateUser);
	}

	public Users changePassword(int id, String newPassword) {
		Users user = userRepository.findById(id).get();
		user.setPassword(newPassword);
		userRepository.save(user);
		return userRepository.save(user);
	}

	public String addRole(UserRole roleBean) {
		String checkRole = roleBean.getRoleName();
		if (roleRespository.existsByRoleName(checkRole)) {
			return "Role already exists!";
		}
		roleRespository.save(roleBean);
		return "Role added successfully.";
	}

	public Users LoginWithPassword(long id, String password) {
		// Users user = userRepository.findByUserId(id);
		Users u = userRepository.findByUserRoleId((int) id);

		if (u.getPassword().equals(password))
			return u;
//		} else
//			return "Incorrect Password";	
		else
			System.out.println("incorrect password");
		return null;
	}

	/*
	 * public String loginUserByEmail(String email) throws
	 * UnsupportedEncodingException, MessagingException { Users user =
	 * userRepository.findByEmail(email); if (user != null) { if
	 * (user.isAccountStatus() == false) { return
	 * "Your account is not verified yet.\nCheck your email for verification link.";
	 * } else if (user.isAccountNonLocked() == false) { return
	 * "Your account is blocked.  Write complaint message to admin."; } String OTP =
	 * RandomString.make(8);
	 * 
	 * user.setOneTimePassword(OTP); user.setOtpRequestedTime(new Date());
	 * user.setFailedAttempt(3); userRepository.save(user);
	 * 
	 * boolean isOTPSentSUccessfully = sendOTPEmail(user, OTP); if
	 * (isOTPSentSUccessfully) return "We've sent an One-Time-Password (OTP) " +
	 * "to your email " + user.getEmail() + ". " +
	 * "Kindly check your email and use the provided OTP to login. "; } else {
	 * return "User not found"; } return null; }
	 */
	/*
	 * public boolean sendOTPEmail(Users user, String OTP) throws
	 * UnsupportedEncodingException, MessagingException {
	 * 
	 * String toAddress = user.getEmail(); String fromAddress =
	 * "Trng2@evolvingsols.com"; String senderName = "Event Management"; String
	 * subject = "Here's your One Time Password (OTP)";
	 * 
	 * String content = "<p>Hello " + user.getUserName() + "</p>" +
	 * "<p>For security reason, you're required to use the following " +
	 * "One Time Password to login:</p>" + "<p><b>" + OTP + "</b></p>" + "<br>" +
	 * "<p>Thank you</p>";
	 * 
	 * MimeMessage message = mailSender.createMimeMessage(); MimeMessageHelper
	 * helper = new MimeMessageHelper(message);
	 * 
	 * helper.setFrom(fromAddress, senderName); helper.setTo(toAddress);
	 * helper.setSubject(subject); helper.setText(content, true);
	 * mailSender.send(message);
	 * 
	 * return true; }
	 * 
	 * public LoginTemp verifyLoginWithOTP(String email, String otp) { Users user =
	 * userRepository.findByEmail(email); if (user.isAccountNonLocked()) { if
	 * (user.getOneTimePassword().equals(otp)) { user.setOneTimePassword(null);
	 * user.setFailedAttempt(0); user.setOtpRequestedTime(null);
	 * userRepository.save(user);
	 * 
	 * return new LoginTemp("OTP verified successfully.", user, true); } else { int
	 * remainingAttempt; if (user.getFailedAttempt() > 0) { remainingAttempt =
	 * user.getFailedAttempt() - 1; user.setFailedAttempt(remainingAttempt);
	 * userRepository.save(user);
	 * 
	 * String msg = "You have entered wrong OTP." + "You have " + (remainingAttempt
	 * + 1) + " attempt(s) to enter correct OTP."; return new LoginTemp(msg, null,
	 * false);
	 * 
	 * } else { user.setFailedAttempt(0); user.setAccountNonLocked(false);
	 * user.setLockTime(new Date()); user.setOneTimePassword(null);
	 * user.setOtpRequestedTime(null); userRepository.save(user); return new
	 * LoginTemp("Your account has been locked due to 3 failed attempts.", null,
	 * false); } } } else { return new
	 * LoginTemp("Your account is blocked.  Write complaint message to admin.",
	 * null, false); } }
	 */

	/*
	 * public ResponseAPI verifyLoginWithPassword(String email, String password) {
	 * Users user = userRepository.findByEmail(email);
	 * 
	 * if (user != null) { if (user.isAccountStatus() == true) { if
	 * (user.isAccountNonLocked()) { if (user.getPassword().equals(password)) {
	 * return new LoginTemp("", user, true); } else return new
	 * LoginTemp("Incorrect Password", null, false); } else { return new
	 * LoginTemp("Your account is blocked. Write complaint message to admin.", null,
	 * false); } } else { return new
	 * LoginTemp("Your account is not verified yet.\nCheck your email for verification link."
	 * , null, false); } } else { return new
	 * LoginTemp("Email not found please enter valid email.", null, false); } }
	 */

}