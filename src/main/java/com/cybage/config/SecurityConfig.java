/*
 * package com.cybage.config;
 * 
 * import javax.sql.DataSource;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.http.HttpMethod; import
 * org.springframework.security.config.annotation.authentication.builders.
 * AuthenticationManagerBuilder; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfiguration; import
 * org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter; import
 * org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; import
 * org.springframework.security.crypto.password.NoOpPasswordEncoder; import
 * org.springframework.security.crypto.password.PasswordEncoder;
 * 
 * @Configuration
 * 
 * @EnableWebSecurity public class SecurityConfig extends
 * WebSecurityConfigurerAdapter {
 * 
 * @Autowired DataSource dataSource;
 * 
 * // @Autowired // public void configureGlobal(AuthenticationManagerBuilder
 * auth) throws Exception { // //
 * auth.inMemoryAuthentication().withUser("user").password("password").roles(
 * "USER").and().withUser("admin") // .password("password").roles("USER",
 * "ADMIN"); // // auth.jdbcAuthentication().dataSource(dataSource); // }
 * 
 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
 * Exception { auth.jdbcAuthentication().dataSource(dataSource)
 * .usersByUsernameQuery("select id, password from users where id=?")
 * .authoritiesByUsernameQuery("select user_id, role_id from user_role where user_id=?"
 * );
 * 
 * 
 * auth.inMemoryAuthentication() .passwordEncoder(passwordEncoder())
 * .withUser("admin") .password(passwordEncoder().encode("admin"))
 * .roles("ADMIN") .and() .passwordEncoder(passwordEncoder())
 * .withUser("shrikant") .password(passwordEncoder().encode("123"))
 * .roles("USER"); } // @Autowired // public void
 * configAuthentication(AuthenticationManagerBuilder auth) throws Exception { //
 * auth.jdbcAuthentication().dataSource(dataSource); // }
 * 
 * // @Override // protected void configure(HttpSecurity http) throws Exception
 * { //
 * http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/welcome")
 * .hasAnyRole("USER", "ADMIN") //
 * .antMatchers("/getEmployees").hasAnyRole("USER",
 * "ADMIN").antMatchers("/addNewEmployee") //
 * .hasAnyRole("ADMIN").anyRequest().authenticated().and().formLogin().loginPage
 * ("/login").permitAll() // .and().logout().permitAll(); // //
 * http.csrf().disable(); // }
 * 
 * @Bean public PasswordEncoder passwordEncoder() { return new
 * BCryptPasswordEncoder();
 * 
 * }
 * 
 * @Override protected void configure(HttpSecurity http) throws Exception {
 * http.httpBasic().and() .authorizeRequests() //
 * .antMatchers("/hello").hasAnyRole("USER","ADMIN")
 * .antMatchers(HttpMethod.GET,"/user/**").permitAll()
 * .antMatchers(HttpMethod.GET,"/admin/**").hasRole("'ADMIN'")
 * .antMatchers(HttpMethod.POST,"/admin/**").hasRole("'ADMIN'")
 * .antMatchers(HttpMethod.PUT,"/admin/**").hasRole("'ADMIN'")
 * .antMatchers(HttpMethod.DELETE,"/admin/**").hasRole("'ADMIN'")
 * .and().csrf().disable(); }
 * 
 * // @Bean // public PasswordEncoder getPasswordEncoder() { // return
 * NoOpPasswordEncoder.getInstance(); //} }
 */