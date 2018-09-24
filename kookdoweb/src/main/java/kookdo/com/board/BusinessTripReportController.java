package kookdo.com.board;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kookdo.common.AbstractAction;
import kookdo.conn.model.BoardVO;
import kookdo.conn.service.BoardService;

@Controller
public class BusinessTripReportController extends AbstractAction{
	
	//@Resource(name="kookdo.conn.service.BoardServiceImpl")
	//@Autowired
	@Resource(name="boardService")
	private BoardService boardService;

	@RequestMapping(value = "businesstripreport", method = RequestMethod.GET)
	public String home(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		return execute(req, res);
	}
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("BusinessTripReportController execute");
		
		List<BoardVO> boardList = boardService.selectBoard();
		
		req.setAttribute("boardList", boardList);
		//req.setAttribute("ab_totalCount", ab_totalCount);
		//req.setAttribute("ab_pageCount", ab_pageCount);
		//req.setAttribute("ab_cpage", ab_cpage);
		
		return "board/businesstripreport";

	}
}
