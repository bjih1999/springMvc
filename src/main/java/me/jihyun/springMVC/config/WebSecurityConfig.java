package me.jihyun.springMVC.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/*
spring security 자동 설정을 오버라이딩

아래의 결과로 WebSecurityConfigurerAdaper Bean이 등록됨으로써, DefaultConfigurerAdaptor가 등록되지 않게되고,
대신에 아래의 WebSecurityConfig가 등록되게 됨
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                    .antMatchers("/", "/hello-security").permitAll() // "/", "hello-security" URL은 모두 허용
                    .anyRequest().authenticated()   // 나머지 URL은 모두 인증 필요
                    .and()
                .formLogin()    // form 로그인 사용
                    .and()
                .httpBasic();   //http Basic 인증 사용
    }

    /*
    passwordEncoder
        패스워드 인코더를 지정해줌
        이 Bean을 등록하지 않으면 There is no PasswordEncoder mapped for the id "null"(로그인 시 패스퉈드 인코더가 매핑되지 않는다)는 오류가 발생함
    */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
