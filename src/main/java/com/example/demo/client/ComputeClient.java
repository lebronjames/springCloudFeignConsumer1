package com.example.demo.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("compute-service")//注解来绑定该接口对应compute-service服务
public interface ComputeClient {

	@RequestMapping(value="/feignadd",method=RequestMethod.GET)
	Integer add(@RequestParam(value="a") Integer a,@RequestParam(value="b") Integer b);
}
