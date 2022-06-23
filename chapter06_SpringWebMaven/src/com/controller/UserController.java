package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import user.bean.UserDTO;
import user.service.UserService;

@Controller
public class UserController {
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userService = null;
	
	@RequestMapping(value = "/user/writeForm", method = RequestMethod.GET)
	public String writeForm() {
		return "/user/writeForm";
	}
	
	@PostMapping(value = "/user/write")
	@ResponseBody
	public void write(@ModelAttribute UserDTO userDTO) {
		
		userService.write(userDTO);
		return ;
	}
	
	@RequestMapping(value = "/user/list", method = RequestMethod.GET)
	public String list() {
		
		return "/user/list";
	}

	@RequestMapping(value = "/user/getList", method = RequestMethod.GET)
	@ResponseBody
	public List<UserDTO> getList() {
		
		return userService.getAllUser();
	}
	
	@RequestMapping(value = "/user/isAlready", method = RequestMethod.GET)
	@ResponseBody
	public String isAlready(@RequestParam(value = "id") String id) {
		
		return userService.isAlready(id);
	}
	
	

}
