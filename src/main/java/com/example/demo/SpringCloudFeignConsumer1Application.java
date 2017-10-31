package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients//开启Feign功能
@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloudFeignConsumer1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudFeignConsumer1Application.class, args);
	}
}
