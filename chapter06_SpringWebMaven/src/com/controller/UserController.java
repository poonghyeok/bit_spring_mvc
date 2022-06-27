package com.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
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
	
	//input file로 들어오는 img가 하나인 경우
//	@PostMapping(value = "/user/upload")
//	@ResponseBody
//	public String upload(@RequestParam MultipartFile img, HttpSession session) {
//		
////		String filePath = "C:\\Spring\\workspace\\chapter06_SpringWebMaven\\WebContent\\storage";
////		String fileName = img.getOriginalFilename();
////		System.out.println("fileName : " + fileName);
////		
////		File file = new File(filePath, fileName);
////		
////		try {
////			//FileCopyUtils.copy(img.getInputStream(), new FileOutputStream(file));
////			img.transferTo(file);
////		} catch (IOException e) {
////			e.printStackTrace();	
////		}
//		
//	//실제 폴더의 위치로 올라가고 싶다. way2.
//	String filePath = session.getServletContext().getRealPath("/storage");
//	System.out.println("실제 폴더 : " + filePath);
//	String fileName = img.getOriginalFilename();
//	
//	File file = new File(filePath, fileName);
//	
//	try {                                                                       
//		//FileCopyUtils.copy(img.getInputStream(), new FileOutputStream(file)); 
//		img.transferTo(file);                                                   
//	} catch (IOException e) {                                                   
//		e.printStackTrace();	                                                
//	}                                                                           
//		
//		return "<img src='../storage/"+ fileName +"' width='200' height='200'>";
//		//fileName은 16진수의 임의의 이름 아니야?
//	}
	
//	//input file 로 들어오는 img라는 name을 가진 요소가 두개 이상인 경우ㅡ
//	@PostMapping(value = "/user/upload")                                         
//	@ResponseBody                                                                
//	public String upload(@RequestParam MultipartFile[] img, HttpSession session) { 
//		String filePath = session.getServletContext().getRealPath("/storage");
//		String[] fileName = new String[2];
//		File file;
//		
//		if(img[0] != null) {
//			fileName[0] = img[0].getOriginalFilename(); //파일명을 구분하기 위해, 뒤에 시간을 붙여주는것도 방법이다. 
//			file = new File(filePath, fileName[0]);
//			try {
//				img[0].transferTo(file);
//			} catch (IllegalStateException | IOException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		if(img[1] != null) {
//			fileName[1] = img[1].getOriginalFilename(); //파일명을 구분하기 위해, 뒤에 시간을 붙여주는것도 방법이다. 
//			file = new File(filePath, fileName[1]);
//			
//			try {
//				img[1].transferTo(file);
//			} catch (IllegalStateException | IOException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		return "<img src='../storage/"+ fileName[0] +"' width='200' height='200'>"
//				+ "<img src='../storage/"+ fileName[1] +"' width='200' height='200'>";
//		
//	}
	
	@PostMapping(value = "/user/upload")                                          
	@ResponseBody                                                                 
	public String upload(@RequestParam("img[]") List<MultipartFile> files, HttpSession session) {
		System.out.println("list upload 컨트롤러 실행");
		StringBuffer sb = new StringBuffer();
		String filePath = session.getServletContext().getRealPath("/storage");
		int imgNum = files.size();
		System.out.println("\n img 개수 : " + imgNum);
		String[] fileName = new String[imgNum];
		File file;
		
		int i = 0;
		for(MultipartFile img : files) {
			fileName[i] = img.getOriginalFilename();
			file = new File(filePath, fileName[i]);
			
			try {
				img.transferTo(file);
				
				sb.append("<img src='../storage/"+ fileName[i] +"' width='200' height='200'>");
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			i++;
		}
			
		return sb.toString();
	}
	
}
