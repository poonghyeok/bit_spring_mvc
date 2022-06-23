package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.SungJukDTO;

@Controller
public class SungJukController {
	
	@GetMapping(value = "/sungJuk/input.do")
	public String input() {
		return "/sungjuk/input";
	}
	
//	@PostMapping(value = "/sungJuk/result.do", produces = "text/html; charset=UTF-8")
//	public ModelAndView result(@RequestParam(value = "name")String name, @RequestParam(value = "kor")int kor, @RequestParam(value = "eng")int eng, @RequestParam(value = "math")int math) {
//		ModelAndView mav = new ModelAndView();
//		int total = kor + eng + math;
//		double avg = total / (3.0);
//		
//		Map<String, String> map = new HashMap<>();
//		map.put("name", name);
//		map.put("total", Integer.toString(total));
//		map.put("avg", String.format("%.3f", avg));
//		
//		mav.addObject("result", map);
//		mav.setViewName("/sungjuk/result");
//		
//		return mav;
//	}
//	1. poong method
	
//	@PostMapping(value = "/sungJuk/result.do", produces = "text/html; charset=UTF-8")
//	public String result(@ModelAttribute SungJukDTO sungJukDTO, Model model) {
//		int total = sungJukDTO.getKor() + sungJukDTO.getEng() + sungJukDTO.getMath();
//		double avg = total / (3.0);
//		
//		sungJukDTO.setTotal(total);
//		sungJukDTO.setAvg(avg);
//		
//		model.addAttribute("sungJukDTO", sungJukDTO);
//		
//		return "/sungjuk/result";
//	}2. lecver
	
	@PostMapping(value = "/sungJuk/result.do", produces = "text/html; charset=UTF-8")
	public String result(@ModelAttribute SungJukDTO sungJukDTO, ModelMap modelMap) {
		int total = sungJukDTO.getKor() + sungJukDTO.getEng() + sungJukDTO.getMath();
		double avg = total / (3.0);
		
		sungJukDTO.setTotal(total);
		sungJukDTO.setAvg(avg);
		
		modelMap.addAttribute("sungJukDTO", sungJukDTO);
		
		return "/sungjuk/result";
	}
	
}
