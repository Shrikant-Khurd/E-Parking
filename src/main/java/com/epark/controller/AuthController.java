/*
 * package com.epark.controller;
 * 
 * import java.io.UnsupportedEncodingException; import java.util.Collections;
 * import java.util.Random;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.security.core.Authentication; import
 * org.springframework.security.core.context.SecurityContextHolder; import
 * org.springframework.security.authentication.AuthenticationManager; import
 * org.springframework.security.authentication.
 * UsernamePasswordAuthenticationToken; //import
 * org.springframework.security.crypto.password.PasswordEncoder; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.epark.dto.LoginDto; import com.epark.model.UserRole; import
 * com.epark.model.Users; import com.epark.repository.RoleRespository; import
 * com.epark.repository.UserRepository;
 * 
 * 
 * @RestController
 * 
 * @RequestMapping("/api/auth") public class AuthController {
 * 
 * private AuthenticationManager authenticationManager;
 * 
 * private UserRepository userRepository; private RoleRespository
 * roleRespository; //private PasswordEncoder passwordEncoder;
 * 
 * @Autowired public AuthController(AuthenticationManager authenticationManager,
 * UserRepository userRepository, RoleRespository roleRespository) {
 * 
 * this.authenticationManager = authenticationManager; this.userRepository =
 * userRepository; this.roleRespository = roleRespository; //
 * this.passwordEncoder = passwordEncoder; }
 * 
 * @PostMapping("/register") public ResponseEntity<String> addUser(@RequestBody
 * Users user){
 * 
 * // user.setPassword(passwordEncoder.encode(user.getPassword())); Random
 * random = new Random(); int userId = (int) (1020300000L + random.nextFloat() *
 * 99999);
 * 
 * //int userId = random.nextInt(99999999); System.out.println(userId);
 * user.setId(userId); UserRole
 * roles=roleRespository.findByRoleName("USER").get();
 * user.setUserRoles(Collections.singletonList(roles));
 * 
 * userRepository.save(user); return new
 * ResponseEntity<String>("User registered successfully.", HttpStatus.CREATED);
 * }
 * 
 * @PostMapping("/login") public ResponseEntity<String> login(@RequestBody
 * LoginDto loginDto){ Authentication authentication=
 * authenticationManager.authenticate( new
 * UsernamePasswordAuthenticationToken(loginDto.getId(),
 * loginDto.getPassword()));
 * SecurityContextHolder.getContext().setAuthentication(authentication);
 * 
 * return new ResponseEntity<>("User signed successfully.", HttpStatus.OK); } }
 */