package com.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SumController {

	@RequestMapping(value = "/input.do", method = RequestMethod.GET)
	public String input() {
		return "/sum/input";
	}
	
//	@RequestMapping(value = "/result.do", method = RequestMethod.GET)
//	public ModelAndView result(@RequestParam(required = false, defaultValue = "0") int x, @RequestParam(required = false, defaultValue = "0") int y) {
//		ModelAndView mav = new ModelAndView();
//		Map<String, Integer> map = new HashMap<>();
//		map.put("x", x);
//		map.put("y", y);
//		map.put("sum", x+y);
//		
//		mav.addObject("calc", map);
//		mav.setViewName("/sum/result");
//		return mav;
//	}
	
//	@RequestMapping(value = "/result.do", method = RequestMethod.GET)
//	public ModelAndView result(@RequestParam Map<String, String> map ) {
//		ModelAndView mav = new ModelAndView();
//		
//		mav.addObject("calc", map);
//		mav.setViewName("/sum/result");
//		return mav;
//	}
	
	@RequestMapping(value = "/result.do", method = RequestMethod.GET)
	public String result(@RequestParam Map<String, String> map, ModelMap modelMap ) {
		modelMap.put("calc", map);
	
		return "/sum/result";
	}//마지막 방식은 뭐지
	
//	@RequestMapping(value = "/result.do", method = RequestMethod.GET)
//	public String result(@ModelAttribute SumDTO sumDTO, Model model ){
//		model.addAttribute("sumDTO", sumDTO);
//	
//		return "/sum/result";
//	}//return 하게 되면 model은 자동으로 forwarding되는거야..
//	
	
}
