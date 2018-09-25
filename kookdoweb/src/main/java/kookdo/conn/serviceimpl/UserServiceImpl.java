package kookdo.conn.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kookdo.conn.dao.UserDAO;
import kookdo.conn.model.UserVO;
import kookdo.conn.service.UserService;

/*@Service("kookdo.conn.service.BoardServiceImpl")  implements BoardService*/

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Resource(name="userDAO")
	private UserDAO userdao;
	
	@Override
	public List<UserVO> login() throws Exception {
		 
        return userdao.login();
    }

}
