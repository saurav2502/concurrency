package com.udemy.currencyexchangeservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.udemy.currencyexchangeservice.**.dao")
public class CurrencyExchangeApplication {

	public static void main(String[] args) {
		System.setProperty("spring.devtools.restart.enabled","false");
		SpringApplication.run(CurrencyExchangeApplication.class, args);
	}

}
