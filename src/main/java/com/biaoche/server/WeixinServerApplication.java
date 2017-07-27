package com.biaoche.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@MapperScan("com.biaoche.server.dao.dao")
@SpringBootApplication
public class WeixinServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeixinServerApplication.class, args);
	}
}
