package com.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity //enables n customizes spring sec
@Configuration //contains config of spring beans
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
	//dep : password enc
	@Autowired
	private PasswordEncoder encoder;
	
	
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
