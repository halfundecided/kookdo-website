package kookdo.com.user;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.json.simple.JSONObject;

import kookdo.conn.model.UserVO;
import kookdo.conn.service.UserService;







@Controller
public class LoginController {
	
	//@Resource(name="kookdo.conn.service.BoardServiceImpl")
		//@Autowired
		@Resource(name="userService")
		private UserService userService;

		@RequestMapping(value = "loginPage", method = {RequestMethod.GET, RequestMethod.POST})
		public String home(HttpServletRequest req, HttpServletResponse res) throws Exception {
			
			return execute(req, res);
		}
		
		public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
			System.out.println("enter login page");

			return "user/login";

		}
		
		
		@RequestMapping(value = "userLogin", method = RequestMethod.POST)
		public void login(HttpServletRequest req, HttpServletResponse res) throws Exception {
			UserVO user = new UserVO();
			user.setUserId(req.getParameter("userId"));
			user.setPassword(req.getParameter("password"));
			checkLogin(user ,req, res);
		}
		
		public void checkLogin(UserVO user, HttpServletRequest req, HttpServletResponse res) throws Exception {

			
			UserVO rslt = userService.login(user.getUserId());
			
			System.out.println(rslt.getUserId() + rslt.getPassword());
			
			JSONObject json = new JSONObject();
			String retString =""; 	// 오류 메시지
			String retType="";		// 로그인 타입
//			json.put("retType", retType);
//			json.put("retString", retString);
			
			
			
			if (rslt == null ) {
				retType  = "5001";
				retString ="해당 계정이 존재하지 않습니다.";
				json.put("retType", retType);
				json.put("retString", retString);
				
			} else if  (rslt != null ) {
				
				// 아이디 일치 여부
				if( !rslt.getUserId().equalsIgnoreCase(user.getUserId())) {
					retType  = "5002";
					retString ="계정(아이디)을(를)  다시 확인하세요";
					json.put("retType", retType);
					json.put("retString", retString);
					// 비밀번호 일치 여부
				}  
				else if ( !rslt.getPassword().equalsIgnoreCase(user.getPassword()) ) {
					retType  = "5003";
					retString ="비밀번호를 다시 확인하세요";
					json.put("retType", retType);
					json.put("retString", retString);
				} 
				else {
					// 권한 별 체크후 메뉴이동
					retType  = "0000";		//정상
					
					//권한별 메뉴설정
					//retString =loginService.loginMenu(rslt);
					retString = "home.do";
					
					// 세션	
					HttpSession session = req.getSession();
					session.setAttribute("loginUser", rslt);
		            
		            //  로그인로그 저장
//		            rslt.setLoginIp(BaseUtil.getClientIP(request));
		            //loginService.loginLog(rslt);
					
					json.put("retType", retType);
					json.put("retString", retString);
				}
			}
			res.setContentType("application/json; charset=utf-8");
			res.getWriter().write(json.toString());
		}
		
		/*			
			List<UserVO> loginResult = userService.login();
			
			req.setAttribute("loginResult", loginResult);
			//req.setAttribute("ab_totalCount", ab_totalCount);
			//req.setAttribute("ab_pageCount", ab_pageCount);
			//req.setAttribute("ab_cpage", ab_cpage);
			*/
		
		@RequestMapping(value = "userLogout")
		public String logout(HttpServletRequest req, HttpServletResponse res) throws Exception {
			HttpSession session = req.getSession();
			session.setAttribute("loginUser", null);
			return "home";
		}

}
