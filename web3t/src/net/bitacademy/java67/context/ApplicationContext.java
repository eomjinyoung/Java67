package net.bitacademy.java67.context;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 역할: 객체 생성 및 의존 객체 주입
 * - @Component 애노테이션이 붙은 클래스를 찾아서 객체를 생성한다. 
 */

public class ApplicationContext {
  private ApplicationContext() {}
  private static ApplicationContext instance;
  public static ApplicationContext getInstance() {
    if (instance == null) {
      instance = new ApplicationContext();
    }
    return instance;
  }
  
  String baseDir;
  HashMap<String,Object> objectPool = new HashMap<String,Object>();
  
  // 이 인터페이스에 선언된 메서드는 forSetter()에서 호출한다.
  static interface Closure {
    void call(Method method) throws Exception;
  }
  
  public void init(File configPropFile) throws Exception {
    createObjectsWithAnnotation();

    createObjectsByProperties(configPropFile);
    
    injectDependencies();
  }

  private void createObjectsWithAnnotation() throws Exception {
    //0. /WEB-INF/classes 폴더와 그 하위 폴더까지 모두 뒤진다.
    File path = new File(baseDir);
    findAndCreateClassWithAnnotation(path, "");
    
    
    //1. @Component 애노테이션이 붙은 클래스를 알아낸다.
    
    
    //2. 그 클래스 목록을 가지고 인스턴스를 생성하여 objectPool 저장한다.
    
  }

  private void findAndCreateClassWithAnnotation(File path, String className) throws Exception {
    // 현재 폴더부터 파일이나 하위 폴더가 있는지 뒤진다.
    String currClassName = className;
    if (className.length() > 0) { 
      currClassName += ".";
    }

    File[] files = path.listFiles();

    for (File f : files) {
      if (f.isFile()) { // 파일일 경우,
        System.out.println(currClassName + f.getName());
        
      } else { // 디렉토리일 경우,
        findAndCreateClassWithAnnotation(f, currClassName + f.getName());
      }
    }
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

  private void createObjectsByProperties(File configPropFile) 
      throws Exception {
    FileReader reader = new FileReader(configPropFile);
    Properties props = new Properties();
    props.load(reader);
    
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

  public void setBaseDir(String baseDir) {
    this.baseDir = baseDir;
  }
}








