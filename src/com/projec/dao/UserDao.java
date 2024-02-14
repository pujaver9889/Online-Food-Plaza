package com.projec.dao;
import java.util.List;
import com.project.dto.UserDTO;

public interface UserDao {
	boolean saveUser(UserDTO user);
	boolean updateUser(UserDTO user);
	boolean deleteUser(String email);
	UserDTO searchUser();
	List<UserDTO> showAllUser();
	

}
