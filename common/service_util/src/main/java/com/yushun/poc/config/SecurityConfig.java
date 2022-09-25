package com.yushun.poc.config;

import com.yushun.poc.handler.OAuth2LoginFailureHandler;
import com.yushun.poc.handler.OAuth2LoginSuccessHandler;
import com.yushun.poc.handler.OAuth2LogoutSuccessHandler;
import com.yushun.poc.service.CustomOAuth2UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomOAuth2UserService oAuth2UserService;

    @Autowired
    private OAuth2LoginSuccessHandler oAuth2LoginSuccessHandler;

    @Autowired
    private OAuth2LoginFailureHandler oAuth2LoginFailureHandler;

    @Autowired
    private OAuth2LogoutSuccessHandler oAuth2LogoutSuccessHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/oauth2/**").permitAll()
                .antMatchers("/level1/**").permitAll()
                .antMatchers("/level2/**").authenticated()
                .and()
                .oauth2Login()
                    .userInfoEndpoint().userService(oAuth2UserService)
                    .and()
                    .successHandler(oAuth2LoginSuccessHandler)
                    .failureHandler(oAuth2LoginFailureHandler)
                .and()
                .logout()
                    .logoutSuccessHandler(oAuth2LogoutSuccessHandler)
                    .invalidateHttpSession(true)
                    .clearAuthentication(true)
                    .permitAll();

        http.formLogin();
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
//                .withUser("yushun").password(new BCryptPasswordEncoder().encode("qpuur990415")).roles("vip1", "vip2")
//                .and()
//                .withUser("root").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1");
//    }
}
