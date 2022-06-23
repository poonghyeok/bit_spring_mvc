package user.service;

import java.util.List;
import java.util.Map;

import user.bean.UserDTO;

public interface UserService {

	public void write(UserDTO userDTO);
	public void checkDI();
	public List<UserDTO> getAllUser();
	public String isAlready(String inputId);
	public UserDTO getUserById(String id);
	public void updateUser(Map<String, String> map);
	public void deleteUserById(String id);
}
