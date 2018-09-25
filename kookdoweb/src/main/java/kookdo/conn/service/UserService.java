package kookdo.conn.service;

import java.util.List;

import kookdo.conn.model.UserVO;

public interface UserService {
	
	public List<UserVO> login() throws Exception;
	
}
