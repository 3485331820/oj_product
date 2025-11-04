package orc.service;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {

    /**
     * 自定义Swagger文档基础信息
     */
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                // 文档核心信息（标题、描述、版本）
                .info(new Info()
                        .title("用户认证API文档") // 文档标题（如“登录/注册接口”）
                        .description("包含用户注册、登录的核心接口，支持账户+密码验证") // 文档描述
                        .version("v1.0.0") // 接口版本
                );

    }
}