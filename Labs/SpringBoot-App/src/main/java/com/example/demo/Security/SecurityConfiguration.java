package com.example.demo.Security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
//@EnableWebSecurity
public class SecurityConfiguration {
	@Autowired
	 private UserDetailsServiceImpl userDetailsService;

	  @Bean
	  public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
		AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
		authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
		return authenticationManagerBuilder.build();
	  }

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http, AuthenticationManager authenticationManager) throws Exception {

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
		.addFilterBefore(new LoginFilter("/login", authenticationManager),
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

