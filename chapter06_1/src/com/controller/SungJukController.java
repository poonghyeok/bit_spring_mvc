package com.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SungJukController {
	
	@GetMapping(value = "/sungJuk/input.do")
	public ModelAndView input() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/sungjuk/input");
		return mav;
	}
	
	@PostMapping(value = "/sungJuk/result.do", produces = "text/html; charset=UTF-8")
	public ModelAndView result(@RequestParam(value = "name")String name, @RequestParam(value = "kor")int kor, @RequestParam(value = "eng")int eng, @RequestParam(value = "math")int math) {
		ModelAndView mav = new ModelAndView();
		int total = kor + eng + math;
		double avg = total / (3.0);
		
		Map<String, String> map = new HashMap<>();
		map.put("name", name);
		map.put("total", Integer.toString(total));
		map.put("avg", String.format("%.3f", avg));
		
		mav.addObject("result", map);
		mav.setViewName("/sungjuk/result");
		
		return mav;
	}
	
}
