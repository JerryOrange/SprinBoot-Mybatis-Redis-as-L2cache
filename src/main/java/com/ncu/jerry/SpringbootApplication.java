package com.ncu.jerry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  //开启组建扫描和自动配置
public class SpringbootApplication {

	public static void main(String[] args) {
	    //负责启动引导应用程序
		SpringApplication.run(SpringbootApplication.class, args);
	}
}
