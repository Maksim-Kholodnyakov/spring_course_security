package com.maksprofff.spring.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class MySecurityConfig {

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.formLogin(form -> {
//            form.loginPage("/login")
//                    .permitAll();
//        }).authorizeRequests();
//        return http.build();
//    }

//    @Bean
//    @Description("In memory Userdetails service registered since DB doesn't have user table ")
//    public UserDetailsService users() {
//        // The builder will ensure the passwords are encoded before saving in memory
//        UserDetails employee1 = User.builder()
//                .username("zaur")
//                .password("zaur")
//                .roles("EMPLOYEE")
//                .build();
//        UserDetails hr = User.builder()
//                .username("elena")
//                .password("elena")
//                .roles("HR")
//                .build();
//        UserDetails manager = User.builder()
//                .username("ivan")
//                .password("ivan")
//                .roles("MANAGER", "HR")
//                .build();
//        return new InMemoryUserDetailsManager(employee1, hr, manager);
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
@Bean
public UserDetailsService users() {
    // The builder will ensure the passwords are encoded before saving in memory
    User.UserBuilder users = User.withDefaultPasswordEncoder();
    UserDetails user = users
            .username("user")
            .password("user")
            .roles("EMPLOYEE")
            .build();
    UserDetails hr = users
            .username("hr")
            .password("hr")
            .roles("HR")
            .build();
    UserDetails manager = users
            .username("manager")
            .password("manager")
            .roles("MANAGER", "HR")
            .build();
    return new InMemoryUserDetailsManager(user, hr, manager);
}

/*
@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests().antMatchers("/").hasAnyRole("EMPLOYEE","MANAGER", "HR")
                .antMatchers("/hr_info").hasRole("HR")
                .antMatchers("/manager_info").hasRole("MANAGER")
                .and().formLogin().permitAll();
    return http.build();
    }
*/
}
