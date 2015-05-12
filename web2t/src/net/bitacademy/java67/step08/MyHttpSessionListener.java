package net.bitacademy.java67.step08;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyHttpSessionListener implements HttpSessionListener {

  @Override
  public void sessionCreated(HttpSessionEvent event) {
    System.out.println("sessionCreated():" + event.getSession().getId());
    
    
  }

  @Override
  public void sessionDestroyed(HttpSessionEvent event) {
    System.out.println("sessionDestroyed():" + event.getSession().getId());
    
  }

}
