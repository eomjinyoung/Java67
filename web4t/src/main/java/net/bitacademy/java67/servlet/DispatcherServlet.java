package net.bitacademy.java67.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.java67.annotation.RequestMapping;
import net.bitacademy.java67.context.ApplicationContext;

import org.reflections.ReflectionUtils;

/* 실습 목표: 메서드의 파라미터 분석하여 원하는 값을 자동으로 넣어주기
 */

@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      String servletPath = request.getServletPath();
      
      ApplicationContext beanContainer = ApplicationContext.getInstance();
      Object controller = beanContainer.getBean(servletPath);
      if (controller == null) {
        throw new Exception("해당 URL의 자원을 찾을 수 없습니다!");
      }
      
      // controller 객체의 클래스 정보로부터 호출할 메서드를 찾는다.
      @SuppressWarnings("unchecked")
      Set<Method> methodList = ReflectionUtils.getMethods(
          controller.getClass(), // 클래스 정보 
          ReflectionUtils.withAnnotation(RequestMapping.class) // 찾는 조건
      );
      
      // @RequestMapping 애노테이션이 붙은 메서드를 호출한다.
      String viewUrl = null;
      List<Object> paramValues = null;
      for (Method m : methodList) {
        // 메서드를 호출하기 전에 메서드의 파라미터를 분석한다.
        // 분석한 결과에 맞춰서 파라미터 값을 준비한다.
        paramValues = analyzeMethodParameter(m, request, response);
        
        // 준비한 파라미터 값을 가지고 메서드를 호출한다.
        viewUrl = (String)m.invoke(controller, paramValues.toArray());
        break;
      }
      
      if (viewUrl.startsWith("redirect:")) {
        response.sendRedirect(viewUrl.substring(9));
        return;
      } else {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher rd = request.getRequestDispatcher(viewUrl);
        rd.include(request, response);
      }
      
    } catch (Exception e) {
      RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
      request.setAttribute("error", e);
      rd.forward(request, response);
      return;
    }
  }

  private List<Object> analyzeMethodParameter(Method m,
      HttpServletRequest request, HttpServletResponse response) 
          throws Exception {
    
    // 파라미터 값을 저장할 컬렉션(Collection)을 준비한다.
    ArrayList<Object> paramValues = new ArrayList<Object>();
    
    /* m이 가리키는 메서드의 시그너처(signature)가 다음과 같다고 가정하자!
     * 예) String list(
     *          HttpServletRequest request, 
     *          int pageNo, 
     *          int pageSize, 
     *          String word,
     *          String order)
     * 
     * getParameters()의 리턴 값?
     * HttpServletRequest --> Parameter[0]
     * int                --> Parameter[1]
     * int                --> Parameter[2]
     * String             --> Parameter[3]
     * String             --> Parameter[4]
     */
    
    Parameter[] params = m.getParameters();
    Class<?> paramType = null;
    String value = null;
    for (Parameter param : params) {
      paramType = param.getType();
      
      if (paramType.isInstance(request)) {
        paramValues.add(request);
      } else if (paramType.isInstance(response)) {
        paramValues.add(response);
      } else if (paramType.isPrimitive() || paramType == String.class) {
        value = request.getParameter(param.getName());
        paramValues.add(convertToPrimitiveValue(value, paramType));
      } else {
        paramValues.add(convertToObject(request, paramType));
      }
    }
    
    return paramValues;
  }
  
  private Object convertToObject(
      HttpServletRequest request, Class<?> paramType) throws Exception {
    //1) 파라미터 타입에 해당하는 객체를 생성한다.
    Object obj = paramType.newInstance();

    //2) 클래스의 셋터 메서드를 추출한다.
    Method[] methods = paramType.getMethods();
    String propertyName = null;
    String paramValue = null;
    for (Method m : methods) {
      if (m.getName().startsWith("set")) {
        propertyName = getPropertyName(m.getName()); // 메서드 이름에서 프로퍼티 이름을 얻는다.
        paramValue = request.getParameter(propertyName); // 프로퍼티 이름과 일치하는 파라미터 값을 꺼낸다.
        if (paramValue != null) { // 파라미터 값이 있다면, 셋터 메서드를 호출한다.
          m.invoke(obj, convertToPrimitiveValue(paramValue, 
                          m.getParameters()[0].getType()));
        }
      }
    }
    return obj;
  }
  
  private String getPropertyName(String methodName) {
    StringBuffer buf = new StringBuffer(methodName.substring(3));
    char firstChar = buf.charAt(0);
    if (firstChar >= 'A' && firstChar <= 'Z') { // 대문자 여부 검사
      buf.setCharAt(0, firstChar += 0x20); // 첫 번째 문자를 소문자로 변경한다.
    }
    return buf.toString();
  }

  private Object convertToPrimitiveValue(String value, Class<?> targetType) {
    String typeName = targetType.getSimpleName(); 
    if (value != null) {
      switch (typeName) {
      case "boolean": return Boolean.parseBoolean(value);
      case "byte": return Byte.parseByte(value);
      case "short": return Short.parseShort(value);
      case "int": return Integer.parseInt(value);
      case "long": return Long.parseLong(value);
      case "float": return Float.parseFloat(value);
      case "double": return Double.parseDouble(value);
      case "char": return value.charAt(0);
      default: return value;  
      }
    } else {
      switch (typeName) {
      case "boolean": return false;
      case "String": return null;
      default: //byte, char, short, int, long, float, double 
        return 0;  
      }
    }
  }
  
}










