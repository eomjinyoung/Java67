package step01;

import java.util.Date;

public class Board {
  int       no;
  String    title;
  String    cotent;
  int       views;
  Date      createDate;
  
  
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getCotent() {
    return cotent;
  }
  public void setCotent(String cotent) {
    this.cotent = cotent;
  }
  public int getViews() {
    return views;
  }
  public void setViews(int views) {
    this.views = views;
  }
  public Date getCreateDate() {
    return createDate;
  }
  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }
  
  
}
