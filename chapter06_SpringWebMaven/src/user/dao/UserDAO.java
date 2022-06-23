package user.dao;

import java.util.List;
import java.util.Map;

import user.bean.UserDTO;

public interface UserDAO {

	public void write(UserDTO userDTO);
	public List<UserDTO> getAllUser();
	public UserDTO getUserById(String searchId);
	public void updateUser(Map<String, String> map);
	public void deleteUserById(String deleteId);
	
}
