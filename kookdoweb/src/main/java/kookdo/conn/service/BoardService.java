package kookdo.conn.service;

import java.util.List;

import kookdo.conn.model.BoardVO;

public interface BoardService {
	
	public List<BoardVO> selectBoard() throws Exception;
	
}