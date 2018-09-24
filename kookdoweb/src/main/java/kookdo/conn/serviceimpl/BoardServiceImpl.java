package kookdo.conn.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import kookdo.conn.dao.BoardDAO;
import kookdo.conn.model.BoardVO;
import kookdo.conn.service.BoardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*@Service("kookdo.conn.service.BoardServiceImpl")  implements BoardService*/

@Service("boardService")
public class BoardServiceImpl implements BoardService{
	
	@Resource(name="boardDAO")
	private BoardDAO boarddao;
	
	@Override
	public List<BoardVO> selectBoard() throws Exception {
		 
        return boarddao.selectBoard();
    }

}
