package com.idat.SetiembreIIIE.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) //apertura todos los metodos de seguridad
public class ConfigSecurity{
	
//	*********************************************************************************************
//	Código para la version 2.7.3
	
	@Bean
	public UserDetailsService userDetail() {
		
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(
				User.withUsername("admin").password(encriptado().encode("12345")).roles("admin").build()				
				);
		manager.createUser(
				User.withUsername("user").password(encriptado().encode("12345")).roles("user").build()				
				);		
		
		return manager;
	}
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
//		autorizar las entradas
		http.authorizeRequests()
		.antMatchers("/producto/v1/*").access("hasRole('user')")
		.antMatchers("/cliente/v1/*").access("hasRole('admin')")
		.antMatchers("/proveedor/v1/*").access("hasRole('admin')")
		.and()
		.httpBasic()
		.and()
		.csrf().disable();
		
		return http.build();
		
	}
	
	
	
//	*********************************************************************************************
//	Código para la version 2.6.7
	
//	clase principal extender de WebSecurityConfigurerAdapter
	
//	->source -> implements methods
	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		
//		auth.inMemoryAuthentication().withUser("admin").password(encriptado().encode("12345")).roles("admin");
//		auth.inMemoryAuthentication().withUser("user").password(encriptado().encode("12345")).roles("user");
//		
//	}
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		
//		http.authorizeRequests()
//		.antMatchers(HttpMethod.GET).access("hasRole('user')")
//		.antMatchers("/producto/v1/*").access("hasRole('admin')")
//		.and()	
//		.httpBasic()
//		.and()
//		.csrf().disable();
//		
//	}	
	
	
//	*********************************************************************************************
//	Código para de Encriptado válido para ambas versiones en Security
	
	@Bean
	public PasswordEncoder encriptado() {
		
		return new BCryptPasswordEncoder();
	}

	

}
