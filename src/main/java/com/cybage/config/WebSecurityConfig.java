/*
 * package com.cybage.config;
 * 
 * import javax.sql.DataSource;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.http.HttpMethod; import
 * org.springframework.security.authentication.AuthenticationManager; import
 * org.springframework.security.authentication.jaas.memory.
 * InMemoryConfiguration; import org.springframework.security.config.Customizer;
 * import
 * org.springframework.security.config.annotation.authentication.builders.
 * AuthenticationManagerBuilder; import
 * org.springframework.security.config.annotation.authentication.configuration.
 * AuthenticationConfiguration; import
 * org.springframework.security.config.annotation.method.configuration.
 * EnableMethodSecurity; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import org.springframework.security.core.userdetails.User;
 * import org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; import
 * org.springframework.security.crypto.password.PasswordEncoder; import
 * org.springframework.security.provisioning.InMemoryUserDetailsManager; import
 * org.springframework.security.web.SecurityFilterChain;
 * 
 * @Configuration
 * 
 * @EnableWebSecurity
 * 
 * @EnableMethodSecurity public class WebSecurityConfig {
 * 
 * 
 * @Autowired DataSource dataSource;
 * 
 * 
 * @Bean public UserDetailsService
 * userDetailsService(AuthenticationManagerBuilder auth) throws Exception {
 * auth.jdbcAuthentication() .dataSource(dataSource)
 * .usersByUsernameQuery("select id, password from users where id=?")
 * .authoritiesByUsernameQuery("select role_name from user_role where role_name=?"
 * ); }
 * 
 * 
 * 
 * @Autowired public void configureGlobal(AuthenticationManagerBuilder auth)
 * throws Exception { auth.jdbcAuthentication() .dataSource(dataSource)
 * .usersByUsernameQuery("select id, password, role_id from users where id=?")
 * .authoritiesByUsernameQuery("select role_id, role_name from user_role where role_name=?"
 * );
 * 
 * }
 * 
 * 
 * @Bean public SecurityFilterChain securityFilterChain(HttpSecurity http)
 * throws Exception { http.csrf().disable() // .authorizeRequests()
 * .authorizeHttpRequests().requestMatchers("/api/auth/**").permitAll() //
 * .requestMatchers(HttpMethod.GET).permitAll()
 * .anyRequest().authenticated().and().httpBasic(); return http.build(); }
 * 
 * @Bean public AuthenticationManager
 * authenticationManager(AuthenticationConfiguration
 * authenticationConfiguration) throws Exception { return
 * authenticationConfiguration.getAuthenticationManager(); }
 * 
 * @Bean public PasswordEncoder passwordEncoder() { return new
 * BCryptPasswordEncoder(); }
 * 
 * 
 * @Bean public UserDetailsService users() { UserDetails admin =
 * User.builder().username("admin").password("password").roles("ADMIN").build();
 * UserDetails user =
 * User.builder().username("user").password("password").roles("USER").build();
 * // return new // InMemoryDetailsManager(admin, // user); return new
 * InMemoryUserDetailsManager(admin, user); }
 * 
 * 
 * 
 * @Bean public SecurityFilterChain securityFilterChain(HttpSecurity http)
 * throws Exception { http.httpBasic().and() // http.csrf().disable()
 * .authorizeHttpRequests() .requestMatchers(HttpMethod.GET,
 * "/user/**").permitAll() .and() .authorizeHttpRequests()
 * .requestMatchers(HttpMethod.GET, "/admin/**").hasRole("'Administrator'")
 * .requestMatchers(HttpMethod.POST, "/admin/**").hasRole("'Administrator'")
 * .requestMatchers(HttpMethod.PUT, "/admin/**").hasRole("'Administrator'")
 * .requestMatchers(HttpMethod.DELETE, "/admin/**").hasRole("'Administrator'")
 * .and().csrf().disable(); return http.build(); /* http.csrf().disable()
 * .authorizeHttpRequests((authorize)-> authorize.anyRequest().authenticated()
 * ).httpBasic(Customizer.withDefaults()); return http.build();
 * 
 * }
 * 
 * }
 */