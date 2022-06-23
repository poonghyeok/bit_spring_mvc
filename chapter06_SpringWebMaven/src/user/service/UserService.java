package user.service;

import java.util.List;

import user.bean.UserDTO;

public interface UserService {

	public void write(UserDTO userDTO);
	public void checkDI();
	public List<UserDTO> getAllUser();
	public String isAlready(String inputId);
}
