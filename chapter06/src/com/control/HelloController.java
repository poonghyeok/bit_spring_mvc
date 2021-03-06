package com.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

//	@RequestMapping(value = "/hello.do", method=RequestMethod.GET)
//	public ModelAndView hello(){
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("result", "Have a nice day!!");
//		mav.setViewName("/view/hello");
//		
//		return mav;
//	}
	
	@GetMapping(value = "/hello.do", produces = "text/html; charset=UTF-8")
	@ResponseBody
	public String hello() {
		//return "apple";
		return "안녕하세요 스프링!";
	}
	
	
	
}
