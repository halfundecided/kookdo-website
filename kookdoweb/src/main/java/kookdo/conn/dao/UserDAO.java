package kookdo.conn.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kookdo.conn.model.UserVO;

@Repository
public class UserDAO {


	@Inject
    private SqlSession sqlSession;
    
    public List<UserVO> login() throws Exception {
        return sqlSession.selectList("user.login", null);
    }
}
