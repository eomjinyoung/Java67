package net.bitacademy.java67.domain;

import java.io.Serializable;
import java.sql.Date;

public class BoardLogVo implements Serializable {
  private static final long serialVersionUID = 1L;
  
  public static final String ACTION_INSERT = "I";
  public static final String ACTION_UPDATE = "U";
  public static final String ACTION_DELETE = "D";
  
  protected int     no;
  protected String  ip;
  protected Date    actionDate;
  protected String  actionType;
  protected int     boardNo;
  
  @Override
  public String toString() {
    return "BoardLogVo [no=" + no + ", ip=" + ip + ", actionDate=" + actionDate
        + ", actionType=" + actionType + ", boardNo=" + boardNo + "]";
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }

  public Date getActionDate() {
    return actionDate;
  }

  public void setActionDate(Date actionDate) {
    this.actionDate = actionDate;
  }

  public String getActionType() {
    return actionType;
  }

  public void setActionType(String actionType) {
    this.actionType = actionType;
  }

  public int getBoardNo() {
    return boardNo;
  }

  public void setBoardNo(int boardNo) {
    this.boardNo = boardNo;
  }
  
  
  
}
