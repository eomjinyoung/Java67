[Expression Language]
- 자바 객체의 프로퍼티 값을 쉽게 꺼내는 기술
- 스크립트 류의 문법처럼 점(.)이나 대괄호([])를 사용하여 프로퍼티를 가리킨다.
- 간단한 연산 기능을 구비하고 있다.

* 표기법
${객체명.프로퍼티명}
${객체명["프로퍼티명"]}

* EL에서 기본으로 제공하는 객체
1) 보관소를 가리키는 객체명
pageScope: PageContext에 대해서 getAttribute() 호출 
requestScope: ServletRequest에 대해서 getAttribute() 호출 
sessionScope: HttpSession에 대해서 getAttribute() 호출 
applicationScope: ServletContext에 대해서 getAttribute() 호출 

2) Servlet/JSP에서 제공하는 객체
pageContext: PageContext 객체 참조변수
servletContext: ServletContext 객체 --> ${pageContext.servletContext.xxxx}
session: HttpSession 객체 --> ${pageContext.session.xxxx}
request: ServletRequest 객체 --> ${pageContext.request.xxxx}
response: ServletResponse 객체
param: getParameter("xxx")  --> ${param.파라미터명}
paramValues: getParameterValues("xxx") --> ${paramValues.파라미터명}
header: getHeader("xxx") --> ${header.헤더명}
headerValues: getHeaders("xxx") --> ${headerValues.헤더명}
cookie: getCookies() --> ${cookie.쿠키이름}
initParam: getInitParameter("xxx") --> {initParam.파라미터명}



* 보관소를 지정하지 않으면 다음 순서대로 객체를 찾는다.
PageContext -> ServletRequest -> HttpSession -> ServletContext
















