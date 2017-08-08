package com.iris.study.springboot.controller;

import com.iris.study.springboot.vo.response.RestReturnObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {

	@RequestMapping("/world")
	@ResponseBody
	public RestReturnObject hello(String msg) {
		return RestReturnObject.generateSuccessObject("Hello world ! return : " + msg);
	}
}
