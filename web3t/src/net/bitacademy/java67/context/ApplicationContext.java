package net.bitacademy.java67.context;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 역할: 객체 생성 및 의존 객체 주입 */

public class ApplicationContext {
  // Singleton 패턴 적용
  // 1) 생성자를 private으로 선언하여 외부에서 직접 객체를 생성하지 못하도록 한다.
  private ApplicationContext() {}
  
  // 2) 인스턴스 주소를 저장할 static 변수를 준비한다.
  private static ApplicationContext instance;
  
  // 3) 인스턴스를 리턴하는 static 메서드를 준비한다.
  public static ApplicationContext getInstance() {
    if (instance == null) {
      instance = new ApplicationContext();
    }
    return instance;
  }
  // Singleton 패턴 끝!
  
  HashMap<String,Object> objectPool = new HashMap<String,Object>();
  
  // 이 인터페이스에 선언된 메서드는 forSetter()에서 호출한다.
  static interface Closure {
    void call(Method method) throws Exception;
  }
  
  public void init(File configPropFile) throws Exception {
    FileReader reader = new FileReader(configPropFile);
    Properties props = new Properties();
    props.load(reader);

    createObjects(props);
    
    injectDependencies();
  }

  private void injectDependencies() throws Exception {
    Class<?> clazz;
    
    for (Object obj : objectPool.values()) {
      clazz = obj.getClass();
      
      forSetter(clazz, new Closure() {
        @Override
        public void call(Method setter) throws Exception {
          Object dependency = findDependency(
              setter.getParameters()[0].getType());
          if (dependency != null) {
            setter.invoke(obj, dependency);
          }
        }
      });
    }
  }
  
  private void forSetter(Class<?> clazz, Closure closure) throws Exception {
    Method[] methods = clazz.getMethods();
    for (Method m : methods) {
      if (m.getName().startsWith("set") 
          && m.getParameterCount() == 1) {
        closure.call(m);
      }
    }
  }
  
  private Object findDependency(Class<?> paramType) {
    for (Object dependency : objectPool.values()) {
      if (paramType.isInstance(dependency)) {
        return dependency;
      }
    }
    return null;
  }

  private void createObjects(Properties props) throws ClassNotFoundException,
      InstantiationException, IllegalAccessException {
    Class<?> clazz = null; 
    for (Map.Entry<Object, Object> entry : props.entrySet()) {
      clazz = Class.forName((String)entry.getValue());
      objectPool.put((String)entry.getKey(), clazz.newInstance());
    }
  }
  
  public void addBean(String name, Object instance) {
    objectPool.put(name, instance);
  }
  
  public Object getBean(String name) {
    return objectPool.get(name);
  }
}








