package orc;



import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot应用程序的主启动类
 * 标注@SpringBootApplication表示这是一个Spring Boot应用
 */
@SpringBootApplication
@MapperScan("orc.mapper")
public class DemoApplication {

    public static void main(String[] args) {
        // 启动Spring Boot应用
        SpringApplication.run(DemoApplication.class, args);
    }
}
