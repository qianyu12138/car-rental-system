package cn.yd.carrentalsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.yd.carrentalsystem.mapper")
public class CarRentalSystemApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(CarRentalSystemApplication.class, args);
    }

}
