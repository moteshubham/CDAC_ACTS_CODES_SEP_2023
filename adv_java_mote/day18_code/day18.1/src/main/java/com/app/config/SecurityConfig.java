package com.app.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity //enables n customizes spring sec
@Configuration //contains config of spring beans
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
	//dep : password enc
	@Autowired
	private PasswordEncoder encoder;
	
	//for in mem authentication
	@Bean
	public UserDetailsService userDetailsService() {
		User customer=new User("Rama",encoder.encode("12345"), 
				List.of(new SimpleGrantedAuthority("ROLE_ADMIN")));
		User admin=new User("Kiran",encoder.encode("2345"),
				List.of(new SimpleGrantedAuthority("ROLE_CUSTOMER")));
		User user=new User("Medha",encoder.encode("1345"),
				List.of(new SimpleGrantedAuthority("ROLE_USER")));
		
		return new InMemoryUserDetailsManager(customer,admin,user);
	}
	//authorization rules
	@Bean
	public SecurityFilterChain authorizeRequests(HttpSecurity http) throws Exception
	{
		http.authorizeRequests()
		.antMatchers("/products/view").permitAll() //un protected end point
		.antMatchers("/products/purchase").hasRole("CUSTOMER")
		.antMatchers("/products/add").hasRole("ADMIN")
		.anyRequest().authenticated() //all remianing end points : authentication
		.and()
		.httpBasic();//auth scheme : Basic
		return http.build();
	}
}
