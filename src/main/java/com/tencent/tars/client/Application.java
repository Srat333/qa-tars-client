package com.tencent.tars.client;

import com.qq.tars.spring.annotation.EnableTarsServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableTarsServer
public class Application {
	 public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
