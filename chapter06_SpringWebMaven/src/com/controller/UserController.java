package com.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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
	
	@PostMapping(value = "/user/getUser")
	@ResponseBody
	public UserDTO getUser(@RequestParam(value = "id") String id) {
		//return type은 상관이 없나?
		System.out.println("\n getUser controller 실행..!  id = " + id);
		return userService.getUserById(id);
	}
	
	@RequestMapping(value = "/user/updateForm", method = RequestMethod.GET)
	public String updateForm() {
		
		return "/user/updateForm";
	}
	
	@PostMapping(value = "/user/updateUser")
	@ResponseBody
	public void updateUser(@RequestParam Map<String, String> map) {
		System.out.println("update controller 실행 " + map.get("name") + map.get("id") + map.get("pwd"));
		
		userService.updateUser(map);
		return;
	}
	
	@RequestMapping(value = "/user/deleteForm", method = RequestMethod.GET)
	public String deleteForm() {
		
		return "/user/deleteForm";
	}
	
	@PostMapping(value = "/user/deleteUser")
	@ResponseBody
	public void deleteUser(@RequestParam String id) {
		
		userService.deleteUserById(id);
		return ;
	}
	
	@RequestMapping(value = "/user/uploadForm", method = RequestMethod.GET)
	public String uploadForm() {
		
		return "/user/uploadForm";
	}
	
	@PostMapping(value = "/user/upload")
	@ResponseBody
	public void upload(@RequestParam MultipartFile img) {
		
		String filePath = "C:\\Spring\\workspace\\chapter06_SpringWebMaven\\WebContent\\storage";
		String fileName = img.getOriginalFilename();
		
		File file = new File(filePath, fileName);
		
		try {
			FileCopyUtils.copy(img.getInputStream(), new FileOutputStream(file));
			//img.transferTo(file);
		} catch (IOException e) {
			e.printStackTrace();	
		}
		
		return ;
	}
	
}
