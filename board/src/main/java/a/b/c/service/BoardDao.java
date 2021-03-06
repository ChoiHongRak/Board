package a.b.c.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
 
@Repository
public class BoardDao { 
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;
    
    public int updateBoard(Board board) {
        return sqlSessionTemplate.update("a.b.c.service.BoardMapper.updateBoard", board);
    }
    
    public int deleteBoard(int boardNo, String boardPw) {
        Board board = new Board();
        board.setBoardNo(boardNo);
        board.setBoardPw(boardPw);
        return sqlSessionTemplate.delete("a.b.c.service.BoardMapper.deleteBoard", board);
    }
    
    public Board getBoard(int boardNo) {
        return sqlSessionTemplate.selectOne("a.b.c.service.BoardMapper.getBoard", boardNo);
    }
 
    public List<Board> getBoardList(int currentPage, int pagePerRow) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("beginRow", (currentPage-1)*pagePerRow);
        map.put("pagePerRow", pagePerRow);
        return sqlSessionTemplate.selectList("a.b.c.service.BoardMapper.getBoardList", map);
    }
    
    public int getBoardCount() {
        return sqlSessionTemplate.selectOne("a.b.c.service.BoardMapper.getBoardCount");
    }
 
    public int insertBoard(Board board) {
        return sqlSessionTemplate.insert("a.b.c.service.BoardMapper.insertBoard", board);
    }
}
