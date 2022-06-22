package com.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SumController {

	@RequestMapping(value = "/input.do", method = RequestMethod.GET)
	public ModelAndView input() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/sum/input");
		
		return mav;
	}
	
	@RequestMapping(value = "/result.do", method = RequestMethod.GET)
	public ModelAndView result(@RequestParam(value = "x")int x, @RequestParam(value = "y")int y) {
		ModelAndView mav = new ModelAndView();
		Map<String, Integer> map = new HashMap<>();
		map.put("x", x);
		map.put("y", y);
		
		mav.addObject("result", map);
		mav.setViewName("/sum/result");
		
		return mav;
	}
}
