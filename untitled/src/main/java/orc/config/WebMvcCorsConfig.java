package orc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcCorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                // 允许所有前端域名（开发环境使用，生产环境需指定具体域名）
                .allowedOriginPatterns("http://localhost:8080")
                // 允许所有HTTP方法（包含预检请求OPTIONS）
                .allowedMethods("*")
                // 允许所有请求头
                .allowedHeaders("*")
                // 注意：允许所有域名时，通常不允许携带凭证（浏览器限制）
                .allowCredentials(true)
                // 预检请求缓存时间（1小时）
                .maxAge(3600);
    }
}
