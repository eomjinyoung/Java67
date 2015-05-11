package net.bitacademy.java67.step04.vo;


public class ManagerVo {
  
  protected int no;
  protected String name;
  protected  String email;
  protected String photo;
  protected String tel;
  protected String password;
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public int getMno() {
    return no;
  }
  public void setMno(int mno) {
    this.no = mno;
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
  public String getPhoto() {
    return photo;
  }
  public void setPhoto(String photo) {
    this.photo = photo;
  }
  public String getTel() {
    return tel;
  }
  public void setTel(String tel) {
    this.tel = tel;
  }
  
  
}