package net.bitacademy.java67.domain;

import java.io.Serializable;

/* - USERS 테이블의 데이터와 대응 
 * - WAS 사이에 데이터 이전이 가능하도록 직렬화를 허용한다.
 *   => 보통 값 객체는 Serializable 인터페이스를 구현한다. 
 */
public class UserVo implements Serializable {
  private static final long serialVersionUID = 1L;

  protected int         userNo;
  protected String      name;
  protected String      email;
  protected String      tel;
  protected String      homepage;
  protected String      twitter;
  protected String      password;
  
  public int getUserNo() {
    return userNo;
  }
  public void setUserNo(int userNo) {
    this.userNo = userNo;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getTel() {
    return tel;
  }
  public void setTel(String tel) {
    this.tel = tel;
  }
  public String getHomepage() {
    return homepage;
  }
  public void setHomepage(String homepage) {
    this.homepage = homepage;
  }
  public String getTwitter() {
    return twitter;
  }
  public void setTwitter(String twitter) {
    this.twitter = twitter;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  
  
}
