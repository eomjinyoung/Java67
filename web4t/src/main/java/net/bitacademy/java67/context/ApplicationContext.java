package net.bitacademy.java67.context;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import net.bitacademy.java67.annotation.Component;

import org.reflections.Reflections;

/* 역할: 객체 생성 및 의존 객체 주입
 * - @Component 애노테이션이 붙은 클래스를 찾아서 객체를 생성한다. 
 * - 오픈 소스 라이브러리를 이용하여 애노테이션이 붙은 클래스를 쉽게 찾자!
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
  
  HashMap<String,Object> objectPool = new HashMap<String,Object>();
  
  // 이 인터페이스에 선언된 메서드는 forSetter()에서 호출한다.
  static interface Closure {
    void call(Method method) throws Exception;
  }
  
  public void init(File configPropFile) throws Exception {
    findAndCreateClassWithAnnotation();

    createObjectsByProperties(configPropFile);
    
    injectDependencies();
  }

  private void findAndCreateClassWithAnnotation() throws Exception {
    Reflections reflections = new Reflections("net.bitacademy.java67");
    Set<Class<?>> compSet = 
        reflections.getTypesAnnotatedWith(Component.class);
    
    Component compAnno = null;
    String objectName = null;
    
    for (Class<?> clazz : compSet) {
      compAnno = clazz.getAnnotation(Component.class);
      objectName = compAnno.value(); 
      if (objectName.length() == 0) {
        objectName = clazz.getName(); 
      }
      objectPool.put(objectName, clazz.newInstance());
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
}








