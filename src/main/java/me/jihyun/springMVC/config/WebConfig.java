package me.jihyun.springMVC.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/*
@EnableWebMvc를 사용하면 안되는 이유
    - 스프링부트가 제공하는 모든 설정이 사라지고 직접 모든 설정을 해주어야함
 */

@Configuration
public class WebConfig implements WebMvcConfigurer {

}
