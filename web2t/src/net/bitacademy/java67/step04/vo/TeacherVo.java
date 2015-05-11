package net.bitacademy.java67.step04.vo;


public class TeacherVo {
  @Override
	public String toString() {
		return "TeacherVo [tno=" + tno + ", name=" + name + ", photo=" + photo
				+ ", tel=" + tel + ", email=" + email + ", wage=" + wage
				+ ", pwd=" + pwd + ", addr=" + addr + "]";
	}
protected int     tno;
  protected String  name;
  protected String  photo;
  protected String  tel;
  protected String  email;
  protected int     wage;
  protected String  pwd;
  protected String  addr;
public int getTno() {
	return tno;
}
public void setTno(int tno) {
	this.tno = tno;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
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
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public int getWage() {
	return wage;
}
public void setWage(int wage) {
	this.wage = wage;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
public String getAddr() {
	return addr;
}
public void setAddr(String addr) {
	this.addr = addr;
}
  
  
}
