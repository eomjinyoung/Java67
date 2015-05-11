package net.bitacademy.java67.step04.vo;

import java.sql.Date;

public class LectureVo {
  protected int     lno;
  protected String  title;
  protected String  intro;
  protected int     capa;
  protected Date    st_date;
  protected Date    ed_date;
  protected int     hours;
  protected int     days;
  protected int     cnt;
  protected int     mno;
  protected int     cno;
  
  
  
  public int getLno() {
    return lno;
  }
  public void setLno(int lno) {
    this.lno = lno;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getIntro() {
    return intro;
  }
  public void setIntro(String intro) {
    this.intro = intro;
  }
  public int getCapa() {
    return capa;
  }
  public void setCapa(int capa) {
    this.capa = capa;
  }
  public Date getSt_date() {
    return st_date;
  }
  public void setSt_date(Date st_date) {
    this.st_date = st_date;
  }
  public Date getEd_date() {
    return ed_date;
  }
  public void setEd_date(Date ed_date) {
    this.ed_date = ed_date;
  }
  public int getHours() {
    return hours;
  }
  public void setHours(int hours) {
    this.hours = hours;
  }
  public int getDays() {
    return days;
  }
  public void setDays(int days) {
    this.days = days;
  }
  public int getCnt() {
    return cnt;
  }
  public void setCnt(int cnt) {
    this.cnt = cnt;
  }
  public int getMno() {
    return mno;
  }
  public void setMno(int mno) {
    this.mno = mno;
  }
  public int getCno() {
    return cno;
  }
  public void setCno(int cno) {
    this.cno = cno;
  }
  
  
  
}
