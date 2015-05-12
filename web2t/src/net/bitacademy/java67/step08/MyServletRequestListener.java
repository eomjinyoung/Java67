package net.bitacademy.java67.step08;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyServletRequestListener implements ServletRequestListener {

  @Override
  public void requestInitialized(ServletRequestEvent event) {
    // 요청이 들어올 때
    System.out.println("requestInitialized()");
    event.getServletRequest().setAttribute("time", System.currentTimeMillis());
  }

  @Override
  public void requestDestroyed(ServletRequestEvent event) {
    // 요청이 나갈 때
    System.out.println("requestDestroyed()");
    long start = (long)event.getServletRequest().getAttribute("time");
    System.out.println("요청처리시간:" + (System.currentTimeMillis() - start));
  }


}






