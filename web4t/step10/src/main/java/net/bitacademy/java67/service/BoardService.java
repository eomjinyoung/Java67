package net.bitacademy.java67.service;

import java.util.HashMap;
import java.util.List;

import net.bitacademy.java67.dao.BoardDao;
import net.bitacademy.java67.dao.BoardLogDao;
import net.bitacademy.java67.domain.BoardLogVo;
import net.bitacademy.java67.domain.BoardVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/* Service 객체
 * - Business Logic 수행
 * - Transaction 처리
 * - 서비스 클래스의 메서드 이름을 지을 때 가능한 업무 용어를 사용한다.
 */

@Service
public class BoardService {
  @Autowired
  BoardDao boardDao;
  
  @Autowired
  BoardLogDao boardLogDao;
  
  @Autowired
  PlatformTransactionManager txManager;
  
  public int add(BoardVo board, String ip) {
    // 트랜잭션 정책 지정
    TransactionDefinition txDef = new DefaultTransactionDefinition(
            TransactionDefinition.PROPAGATION_REQUIRED);
    
    // txDef 트랜잭션 정책에 따라 작업할 트랜잭션을 준비한다.
    TransactionStatus txStatus = txManager.getTransaction(txDef);
    
    try {
      int count = boardDao.insert(board); // txStatus 트랜잭션에 작업이 기록됨
      
      logDataAction(board, ip);
      
      // 해당 트랜잭션의 작업을 처리하라.
      txManager.commit(txStatus);  // txStatus에 기록된 작업을 실제 DB에 반영함
      
      return count;
      
    } catch (Exception e) {
      txManager.rollback(txStatus); // txStatus에 기록된 작업을 취소함
      throw e;
    }
  }

  private void logDataAction(BoardVo board, String ip) {
    // 호출자와는 다른 트랜잭션 정책을 가지려면, 
    // 다음과 같이 트랜잭션을 별도로 정의해야 한다.
    TransactionDefinition txDef = new DefaultTransactionDefinition(
            TransactionDefinition.PROPAGATION_REQUIRES_NEW);
    TransactionStatus txStatus = txManager.getTransaction(txDef);
    
    try {
      BoardLogVo boardLog = new BoardLogVo();
      boardLog.setIp(ip);
      boardLog.setActionType(BoardLogVo.ACTION_INSERT + "xxxx");
      boardLog.setBoardNo(board.getNo());
      boardLogDao.insert(boardLog);   // txStatus 트랜잭션에 작업이 기록됨
      txManager.commit(txStatus);
      
    } catch (Exception e) {
      System.out.println("로그 등록 오류 발생!");
      txManager.rollback(txStatus);
    }
  }
  
  public List<BoardVo> list(
      int startIndex, int pageSize, String word, String order) {
    
    HashMap<String,Object> sqlParams = new HashMap<String,Object>();
    sqlParams.put("startIndex", startIndex);
    sqlParams.put("pageSize", pageSize);
    sqlParams.put("word", word);
    sqlParams.put("order", order);
    
    return boardDao.selectList(sqlParams);
  }
  
  public int size(String word) {
    return boardDao.countAll(word);
  }
  
  public BoardVo get(int no) {
    return boardDao.selectOne(no);
  }
  
  public int remove(int no, String ip) {
    int count = boardDao.delete(no);
    
    BoardLogVo boardLog = new BoardLogVo();
    boardLog.setIp(ip);
    boardLog.setActionType(BoardLogVo.ACTION_DELETE);
    boardLog.setBoardNo(no);
    boardLogDao.insert(boardLog);
    
    return count;
  }
  
  public int change(BoardVo board, String ip) {
    int count = boardDao.update(board);
    
    BoardLogVo boardLog = new BoardLogVo();
    boardLog.setIp(ip);
    boardLog.setActionType(BoardLogVo.ACTION_UPDATE + "1111");
    boardLog.setBoardNo(board.getNo());
    boardLogDao.insert(boardLog);
    
    return count;
  }
}









