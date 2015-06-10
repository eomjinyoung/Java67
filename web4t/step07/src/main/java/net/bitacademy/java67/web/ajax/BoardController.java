package net.bitacademy.java67.web.ajax;

import java.util.HashMap;

import net.bitacademy.java67.dao.BoardDao;
import net.bitacademy.java67.domain.BoardVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;

/* 실습 목표: JSON 데이터 출력 */

@Controller("/board/ajax")
@RequestMapping("/board/ajax")
public class BoardController {
  // 이제 BoardDao는 인터페이스이다.
  // boardDao에 주입되는 것은 mybatis가 만든 BoardDao 구현체이다.
  @Autowired
  BoardDao boardDao;
  
  @RequestMapping("/list")
  public ResponseEntity<String> list(
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
    
    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", "text/plain;charset=UTF-8");
    headers.add("Access-Control-Allow-Origin", "*");
    
    return new ResponseEntity<String>(
                new Gson().toJson(responseData),
                headers,
                HttpStatus.OK);
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
  public ResponseEntity<String> add(BoardVo board) throws Exception {
    boardDao.insert(board);
    
    HashMap<String,Object> responseData = new HashMap<String,Object>();
    responseData.put("status", "success");
    
    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", "text/plain;charset=UTF-8");
    headers.add("Access-Control-Allow-Origin", "*");
    
    return new ResponseEntity<String>(
                new Gson().toJson(responseData),
                headers,
                HttpStatus.OK);
  }
  
  @RequestMapping("/change")
  public ResponseEntity<String> change(BoardVo board) throws Exception {
    boardDao.update(board);
    
    HashMap<String,Object> responseData = new HashMap<String,Object>();
    responseData.put("status", "success");
    
    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", "text/plain;charset=UTF-8");
    headers.add("Access-Control-Allow-Origin", "*");
    
    return new ResponseEntity<String>(
                new Gson().toJson(responseData),
                headers,
                HttpStatus.OK);
  }
  
  @RequestMapping("/delete")
  public ResponseEntity<String> delete(int no) throws Exception {
    boardDao.delete(no);
    
    HashMap<String,Object> responseData = new HashMap<String,Object>();
    responseData.put("status", "success");
    
    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", "text/plain;charset=UTF-8");
    headers.add("Access-Control-Allow-Origin", "*");
    
    return new ResponseEntity<String>(
                new Gson().toJson(responseData),
                headers,
                HttpStatus.OK);
  }
  
  @RequestMapping("/detail")
  public ResponseEntity<String> detail(int no) throws Exception {
    HashMap<String,Object> responseData = new HashMap<String,Object>();
    responseData.put("status", "success");
    responseData.put("data", boardDao.selectOne(no));
    
    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", "text/plain;charset=UTF-8");
    headers.add("Access-Control-Allow-Origin", "*");
    
    return new ResponseEntity<String>(
                new Gson().toJson(responseData),
                headers,
                HttpStatus.OK);
  }

}










