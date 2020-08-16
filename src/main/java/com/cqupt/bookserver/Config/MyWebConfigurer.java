package com.cqupt.bookserver.Config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName: MyWebConfigurer
 * @Description: 配置类
 * @Author: wsz
 * @Date: 2020/3/27 21:20
 * @Version 1.0
 **/
@SpringBootConfiguration
public class MyWebConfigurer implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //所有请求都允许跨域，使用这种配置方法就不能在interceptor中配置header了
        registry.addMapping("/**").
                allowedOrigins("http://localhost:8089").
                allowCredentials(true).
                allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE").
                allowedHeaders("*").maxAge(3600);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/api/file/**").addResourceLocations("file:" + "f:/vblog/img/");
    }

}
