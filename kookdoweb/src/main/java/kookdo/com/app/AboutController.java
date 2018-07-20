package kookdo.com.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kookdo.common.AbstractAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class AboutController extends AbstractAction{

	@RequestMapping(value = "about", method = RequestMethod.GET)
	public String home(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		return execute(req, res);
	}
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("AboutController execute");
		
		req.setAttribute("msg", "msg");
		
		return "about";

	}

}
