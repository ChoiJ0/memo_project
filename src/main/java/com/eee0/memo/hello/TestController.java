package com.eee0.memo.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class TestController {
	@ResponseBody
	@RequestMapping("/hello")
	public String helloworld() {
		return "hello world!";
	}
}
