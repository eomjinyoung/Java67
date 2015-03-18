package step12.ch03.domain;

//복합 자료형 정의
public class User {
  protected int no;
  protected String name;
  protected String email;
  protected String tel;
  protected String homepage;
  protected String twitter;
  
  @Override
  public String toString() {
    return "User [no=" + no + ", name=" + name + ", email=" + email + ", tel="
        + tel + ", homepage=" + homepage + ", twitter=" + twitter + "]";
  }

  public User() {}
  
  public User(int no, String name, String email, String tel,
      String homepage, String twitter) {
    this.no = no;
    this.name = name;
    this.email = email;
    this.tel = tel;
    this.homepage = homepage;
    this.twitter = twitter;
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
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
  
  
      
}
