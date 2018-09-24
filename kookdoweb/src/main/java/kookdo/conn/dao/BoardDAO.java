package kookdo.conn.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kookdo.conn.model.BoardVO;

@Repository
public class BoardDAO {
	
	@Inject
	//@Resource(name="sqlSession")
	//@Autowired 
    private SqlSession sqlSession;
    
    //@Autowired
	//private SqlSessionTemplate sqlSession;
	
    private static final String Namespace = "kookdo.com.sqlMapper.board";
    
    public List<BoardVO> selectBoard() throws Exception {
        return sqlSession.selectList("sql.selectBoard", null);
    }

}
