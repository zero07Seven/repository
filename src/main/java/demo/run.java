package demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("demo.mapper")//扫描mapper层的位置
public class run {
    public static void main(String[] args){
        SpringApplication.run(run.class,args);
    }
}
