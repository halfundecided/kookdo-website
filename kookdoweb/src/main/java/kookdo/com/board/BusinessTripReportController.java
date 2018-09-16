package kookdo.com.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kookdo.common.AbstractAction;

@Controller
public class BusinessTripReportController extends AbstractAction{
	
	@RequestMapping(value = "businesstripreport", method = RequestMethod.GET)
	public String home(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		return execute(req, res);
	}
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("BusinessTripReportController execute");
		
		req.setAttribute("msg", "출장보고서");
		
		return "board/businesstripreport";

	}
}
