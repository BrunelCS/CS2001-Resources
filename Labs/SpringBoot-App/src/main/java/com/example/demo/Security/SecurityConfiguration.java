package com.example.demo.Security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//@EnableWebSecurity
public class SecurityConfiguration {
	@Autowired
	 private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	    auth.userDetailsService(userDetailsService)
	    .passwordEncoder(new BCryptPasswordEncoder());
	}
	
	
	@Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
      return authenticationConfiguration.getAuthenticationManager();
  }

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http
			.csrf(csrf -> csrf.disable());
		
		http
		.cors((cors) -> cors
			.configurationSource(corsConfigurationSource())
		);
		
		 http.sessionManagement((session) -> session
		            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		        );
		
		http
		.addFilterBefore(new LoginFilter("/login", authenticationManager(http.getSharedObject(AuthenticationConfiguration.class))),
				UsernamePasswordAuthenticationFilter.class)
		.addFilterBefore(new JWTAuthenticationFilter(), 
				UsernamePasswordAuthenticationFilter.class);
		
		 http
			.authorizeHttpRequests((authorize) -> authorize
				.requestMatchers(HttpMethod.POST,"/user/**").permitAll()
				.requestMatchers("/h2-console/**").permitAll()
				.anyRequest().authenticated()
			);

			http
			.headers(headers -> headers
				.frameOptions(frameOptions -> frameOptions
					.sameOrigin()));

		return http.build();
	}
	

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
	    CorsConfiguration configuration = new CorsConfiguration();
	    configuration.setAllowedOrigins(Arrays.asList("http://localhost:5173"));
	    configuration.setAllowedMethods(Arrays.asList("GET","POST"));
	    configuration.setAllowedHeaders(Arrays.asList("*"));
	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", configuration);
	    return source;
	}

	/*
	//If you want to configure an InMemory User for testing
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user = User
				.withUsername("user")
				.password(passwordEncoder().encode("password"))
				.roles("USER")
				.build();
		return new InMemoryUserDetailsManager(user);
	}

	   */
}

