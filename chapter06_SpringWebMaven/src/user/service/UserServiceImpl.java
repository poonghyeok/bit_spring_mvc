package user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import user.bean.UserDTO;
import user.dao.UserDAO;

@Service
public class UserServiceImpl implements UserService {	
	
	@Autowired
	private UserDAO userDAO;
	
	
	public void write(UserDTO userDTO) {
		userDAO.write(userDTO);
	}
	
	public List<UserDTO> getAllUser() {
		List<UserDTO> list = userDAO.getAllUser();
		
		return list;
	}
	
	@Override
	public void checkDI() {
		System.out.println("\nUserServiceImpl이 주입되었습니다!\n");		
	}
	
	@Override
	public String isAlready(String inputId) {
		String result = null;
		UserDTO dto = null;
		dto = userDAO.getUserById(inputId);
		
		if(dto == null) {
			result = "non_exist";
		}else {
			result = "exist";
		}
		
		return result;
	}
	
	
}
