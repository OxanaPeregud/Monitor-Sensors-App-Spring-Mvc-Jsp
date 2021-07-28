package com.peregud.monitorsensors.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

import static com.peregud.monitorsensors.AppConstants.*;

@Configuration
@EnableConfigurationProperties
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DBUserDetailsService DBUserDetailsService;

    @Autowired
    private CustomAuthSuccessHandler customAuthSuccessHandler;

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers(PAGE_START, PAGE_SIGN_UP, PAGE_LOGIN, PAGE_USER_SIGN_UP, PAGE_LOGIN_FAILED,
                        PAGE_ACCESS_DENIED).permitAll()
                .antMatchers(PAGE_USERS_ACCESS).authenticated()
                .antMatchers(PAGE_ADMIN_ACCESS).hasAnyAuthority(ATTR_ADMIN)
                .and().exceptionHandling().accessDeniedHandler(accessDeniedHandler())
                .and().formLogin().loginPage(PAGE_LOGIN)
                .successHandler(customAuthSuccessHandler)
                .failureUrl(PAGE_LOGIN_FAILED).usernameParameter(PARAM_USERNAME)
                .passwordParameter(PARAM_PASSWORD)
                .and().logout().logoutUrl(PAGE_LOGOUT).logoutSuccessUrl(PAGE_LOGIN);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(DBUserDetailsService);
    }
}
