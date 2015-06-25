package net.bitacademy.java67.web.ajax;

import java.util.HashMap;

import net.bitacademy.java67.dao.BoardDao;
import net.bitacademy.java67.domain.BoardVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/* 실습 목표: ContentNegotiatingViewResolver를 사용하기 */

@Controller("/board/ajax")
@RequestMapping("/board/ajax")
public class BoardController {
  @Autowired
  BoardDao boardDao;
  
  @RequestMapping("/list")
  public Object list(
      @RequestParam(required=false,defaultValue="1") int pageNo, 
      @RequestParam(required=false,defaultValue="3") int pageSize, 
      @RequestParam(required=false) String word, 
      @RequestParam(required=false) String order) throws Exception {

    // BoardDao 인터페이스의 selectList()는 한 개의 파라미터를 요구한다.
    // 따라서 SQL 파라미터 값을 맵 객체에 담아서 넘겨야 한다.
    HashMap<String,Object> sqlParams = new HashMap<String,Object>();
    sqlParams.put("startIndex", getStartIndexOfPage(pageNo, pageSize));
    sqlParams.put("pageSize", pageSize);
    sqlParams.put("word", word);
    sqlParams.put("order", order);
    
    
    // 클라이언트에 보낼 데이터를 담을 맵 객체 준비
    HashMap<String,Object> responseData = new HashMap<String,Object>();
    responseData.put("status", "success");
    responseData.put("data", boardDao.selectList(sqlParams));
    responseData.put("pageNo", pageNo);
    responseData.put("pageSize", pageSize);
    responseData.put("maxPage", countTotalPage(pageSize, 
                                    boardDao.countAll(word)));
    
    return responseData;
  }

  private int getStartIndexOfPage(int pageNo, int pageSize) {
    return (pageNo - 1) * pageSize;
  }

  private int countTotalPage(int pageSize, int totalRecords) {
    int maxPage = totalRecords / pageSize;
    if (totalRecords % pageSize > 0) {
      maxPage++;
    }
    return maxPage;
  }
  
  @RequestMapping("/add")
  public Object add(BoardVo board) throws Exception {
    boardDao.insert(board);
    
    HashMap<String,Object> responseData = new HashMap<String,Object>();
    responseData.put("status", "success");
    
    return responseData;
  }
  
  @RequestMapping("/change")
  public Object change(BoardVo board) throws Exception {
    boardDao.update(board);
    
    HashMap<String,Object> responseData = new HashMap<String,Object>();
    responseData.put("status", "success");
    
    return responseData;
  }
  
  @RequestMapping("/delete")
  public Object delete(int no) throws Exception {
    boardDao.delete(no);
    
    HashMap<String,Object> responseData = new HashMap<String,Object>();
    responseData.put("status", "success");
    
    return responseData;
  }
  
  @RequestMapping("/detail")
  public Object detail(int no) throws Exception {
    HashMap<String,Object> responseData = new HashMap<String,Object>();
    responseData.put("status", "success");
    responseData.put("data", boardDao.selectOne(no));
    
    return responseData;
  }

}










