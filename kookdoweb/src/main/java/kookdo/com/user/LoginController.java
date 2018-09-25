package kookdo.com.user;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kookdo.conn.model.UserVO;
import kookdo.conn.service.UserService;







@Controller
public class LoginController {
	
	//@Resource(name="kookdo.conn.service.BoardServiceImpl")
		//@Autowired
		@Resource(name="userService")
		private UserService userService;

		@RequestMapping(value = "login", method = RequestMethod.GET)
		public String home(HttpServletRequest req, HttpServletResponse res) throws Exception {
			
			return execute(req, res);
		}
		
		public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
			System.out.println("LoginController execute");
			
			List<UserVO> loginResult = userService.login();
			
			req.setAttribute("loginResult", loginResult);
			//req.setAttribute("ab_totalCount", ab_totalCount);
			//req.setAttribute("ab_pageCount", ab_pageCount);
			//req.setAttribute("ab_cpage", ab_cpage);
			
			return "user/login";

		}

}
