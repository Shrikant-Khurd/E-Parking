package com.epark.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epark.model.Users;
import com.epark.service.UserService;
import com.epark.model.UserRole;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private UserService userService;

//	@Autowired
//	private UserRepository userRepository;

	@GetMapping("/get-all-users")
	public ResponseEntity<List<Users>> getAllUsers() {
		List<Users> userList = userService.getAllUser();
		return new ResponseEntity<List<Users>>(userList, HttpStatus.OK);
	}

	@GetMapping("/all-customers")
	public ResponseEntity<List<Users>> getAllCustomer(String userRole) {
		List<Users> allUsers = userService.getAllCustomer(userRole);
		return new ResponseEntity<List<Users>>(allUsers, HttpStatus.OK);
	}

	@GetMapping("/all-Parking-Service-Provider")
	public ResponseEntity<List<Users>> getAllParkingServiceProvider(String organizerRole) {
		List<Users> allOrganizers = userService.getAllParkingServiceProvider(organizerRole);
		return new ResponseEntity<List<Users>>(allOrganizers, HttpStatus.OK);
	}

	// To add Role
	@PostMapping("/add-Role")
	public ResponseEntity<String> addRole(@RequestBody UserRole roleBean) {
		String addRoleStatus = userService.addRole(roleBean);
		return new ResponseEntity<String>(addRoleStatus, HttpStatus.OK);
	}

	/*
	 * @PostMapping("/add/event/category") public ResponseEntity<String>
	 * addEventCategory(@RequestBody EventCategory eventCategory) {
	 * 
	 * if (!adminService.findByCategoryName(eventCategory.getCategoryName())) throw
	 * new CategoryAlreadyExistException("Category already exist."); else
	 * adminService.addEventCategory(eventCategory); return new
	 * ResponseEntity<String>("Category added successfully.", HttpStatus.CREATED); }
	 * 
	 * @GetMapping("/all/event/category") public ResponseEntity<List<EventCategory>>
	 * getAllEventCategory() { List<EventCategory> eventList =
	 * adminService.getAllEventCategory(); return new
	 * ResponseEntity<List<EventCategory>>(eventList, HttpStatus.OK); }
	 * 
	 * @GetMapping("/category/byId/{id}") public ResponseEntity<EventCategory>
	 * getEventCategory(@PathVariable int id) { EventCategory eventCategory =
	 * adminService.getEventCategoryById(id); if (eventCategory == null) throw new
	 * RecordNotFoundException("event not found."); return new
	 * ResponseEntity<EventCategory>(adminService.getEventCategoryById(id),
	 * HttpStatus.OK); }
	 * 
	 * @DeleteMapping("/{id}") public ResponseEntity<String>
	 * deleteEventCategory(@PathVariable int id) {
	 * 
	 * EventCategory eventCategory = adminService.deleteEventCategory(id); if
	 * (eventCategory == null) { throw new
	 * RecordNotFoundException("event not found."); } else { return new
	 * ResponseEntity<String>("Category delete successfully", HttpStatus.CREATED); }
	 * }
	 * 
	 * @PutMapping("/update/category/{id}") public ResponseEntity<String>
	 * updateEventCategory(@PathVariable int id, @RequestBody EventCategory
	 * eventCategory) { adminService.updateEventCategory(id, eventCategory); return
	 * new ResponseEntity<String>("Category updated successfully", HttpStatus.OK); }
	 * 
	 * @GetMapping("/all-users") public ResponseEntity<List<Users>>
	 * getAllUsers(String userRole) { List<Users> allUsers =
	 * adminService.getAllUsersByRole(userRole); return new
	 * ResponseEntity<List<Users>>(allUsers, HttpStatus.OK); }
	 * 
	 * @GetMapping("/all-organizers") public ResponseEntity<List<Users>>
	 * getAllorganizers(String organizerRole) { List<Users> allOrganizers =
	 * adminService.getAllorganizersByRole(organizerRole); return new
	 * ResponseEntity<List<Users>>(allOrganizers, HttpStatus.OK); }
	 * 
	 * @GetMapping("/unlock-user/{id}") public ResponseEntity<String>
	 * unlockUser(@PathVariable int id) { adminService.unlockUser(id); return new
	 * ResponseEntity<String>("Account status change successfully", HttpStatus.OK);
	 * }
	 * 
	 * @DeleteMapping("/deleteOrganizer/{id}") public ResponseEntity<String>
	 * deleteUser(@PathVariable int id) { Users user = adminService.deleteUser(id);
	 * if (user == null) { throw new RecordNotFoundException("User not found."); }
	 * else { return new ResponseEntity<String>("Delete user successfully",
	 * HttpStatus.CREATED); } }
	 * 
	 * @PostMapping("/addComplaint/{email}") ResponseEntity<String>
	 * addUserComplaint(@PathVariable String email,@RequestBody UserComplains
	 * userComplains) { if (userRepository.findByEmail(email)==null) throw new
	 * RecordNotFoundException("Email not found please enter valid email."); else
	 * adminService.addUserComplaint(email, userComplains); return new
	 * ResponseEntity<String>("Complaint send successfully", HttpStatus.CREATED); }
	 * 
	 * @GetMapping("/getAllComplains") ResponseEntity<List<UserComplains>>
	 * getAllComplains() { return new
	 * ResponseEntity<List<UserComplains>>(adminService.getAllComplains(),
	 * HttpStatus.OK); }
	 * 
	 * @GetMapping("/complaint-resolved/{complaintId}/{userId}") public
	 * ResponseEntity<String> updateComplaintStatus(@PathVariable int
	 * complaintId, @PathVariable int userId) throws UnsupportedEncodingException,
	 * MessagingException { adminService.updateComplaintStatus(complaintId, userId);
	 * return new
	 * ResponseEntity<String>("Complaint resolved and email send successfully",
	 * HttpStatus.OK); }
	 */
}
