package orc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/*@Configuration*/
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {

        // 1. 创建CORS配置对象
        CorsConfiguration config = new CorsConfiguration();

        // 允许的源地址，*表示允许所有源（生产环境建议指定具体域名）
        config.addAllowedOriginPattern("*");

        // 允许携带凭证（如Cookie）
        config.setAllowCredentials(true);

        // 允许的HTTP方法
        config.addAllowedMethod("GET");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("OPTIONS");

        // 允许的请求头
        config.addAllowedHeader("*");

        // 暴露的响应头（前端可以获取的头信息）
        config.addExposedHeader("Authorization");
        config.addExposedHeader("Content-Type");

        // 预检请求的缓存时间（秒），减少预检请求次数
        config.setMaxAge(3600L);

        // 2. 配置URL映射
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        // 对所有路径应用CORS配置
        source.registerCorsConfiguration("/**", config);

        // 3. 创建并返回CORS过滤器
        return new CorsFilter(source);
    }
}
