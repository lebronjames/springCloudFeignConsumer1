package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.client.ComputeClient;

@RestController
public class ConsumerController {

	@Autowired
	ComputeClient computeClient;
	
	@RequestMapping(value="/feignadd",method=RequestMethod.GET)
	public Integer add() {
		return computeClient.add(20, 30);
	}
}
