package com.example.demo.dtos;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.Filter.AuthenticationFilter;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.AuthService;
@Configuration
public class FilterConfig {

	@Bean
    public FilterRegistrationBean<AuthenticationFilter> authenticationFilter(AuthService authService, UserRepository userRepository) {
        FilterRegistrationBean<AuthenticationFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new AuthenticationFilter(authService, userRepository));
        registrationBean.addUrlPatterns("/api/*", "/admin/*"); // Ensure correct URL pattern
        registrationBean.setOrder(1); // Order in which filter executes
        return registrationBean;
    }
	
}
