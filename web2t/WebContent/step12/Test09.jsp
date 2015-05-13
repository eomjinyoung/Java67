<%@ page import="java.util.ArrayList"%>
<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"%>

[JSP 액션 태그: useBean]
- 인스턴스를 생성하는 자바 코드를 만든다.
- id : 객체를 참조할 때 사용할 이름. 객체를 저장할 때 key로 사용함.
- class: 객체를 생성할 때 사용할 클래스명. Fully-qualified name 이어야 한다.
         패키지명을 포함해야 한다. import와 상관없다.
- scope : 객체를 찾고 보관하는 장소를 지정한다. 기본은 PageContext이다.
          다음 4개의 값을 지정할 수 있다.
          page(PageContext), request(ServletRequest), 
          session(HttpSession), application(ServletContext)
- type : 객체를 가리키는 참조 변수의 타입을 지정한다.
         type 속성을 생략하면 참조 변수의 타입은 class 속성과 같다.
         class 속성을 생략하면 객체를 생성하지 않는다. 찾기만 한다.

<jsp:useBean id="list"
  class="java.util.ArrayList"></jsp:useBean>

<%-- 위의 태그는 다음의 자바 코드와 같다.
java.util.ArrayList list = pageContext.getAttribute("list");
if (list == null) {
  list = new java.util.ArrayList();
  pageContext.setAttribute("list", list);
}
 --%>
  
<%
// 실험: 정말 태그를 통해 객체를 생성할 수 있는지 확인하자!
list.add("홍길동");
list.add("임꺾정");
%>

<%= list.get(0)%>
<%= list.get(1)%>
-------------------------------------------------
<%-- 위의 태그는 다음과 같다. scope 속성의 기본 값은 page이다. --%>
<jsp:useBean id="list2"
  class="java.util.ArrayList"
  scope="page"></jsp:useBean>
  
<%
// scope 지정하지 않으면 객체가 PageContext에 보관된다는 것을 확인하자!
ArrayList r1 = (ArrayList)pageContext.getAttribute("list");

// scope을 page로 설정하면 PageContext에 객체가 보관된다는 것을 확인하자!
ArrayList r2 = (ArrayList)pageContext.getAttribute("list2");
%>  
list == r1 ? <%= list == r1 %>
list2 == r2 ? <%= list2 == r2 %>

--------------------------------------------------
<%-- 이미 해당 보관소에 해당 아이디를 갖는 객체가 있다면, 기존 객체를 리턴한다. 증명하자!  --%>
<%
ArrayList temp = new ArrayList();
temp.add("유관순");
temp.add("신채호");
pageContext.setAttribute("list3", temp);
%>

<jsp:useBean id="list3" class="java.util.ArrayList"></jsp:useBean>

<%=list3.get(0)%>
<%=list3.get(1)%>
-----------------------------------------------------
<%-- 객체를 ServletRequest 보관소에 저장하자. --%>

<jsp:useBean id="list4" class="java.util.ArrayList" scope="request"/>

<%
ArrayList temp2 = (ArrayList)pageContext.getAttribute("list4");
ArrayList temp3 = (ArrayList)request.getAttribute("list4");
%>
PageContext: <%= temp2 %>
ServletRequest: <%= temp3 %>

-----------------------------------------------------
<%-- class와 type을 모두 지정하기 --%>
<jsp:useBean id="list5" 
  class="java.util.ArrayList"
  type="java.util.List"/>

<%--
java.util.List list5 = (java.util.ArrayList)pageContext.getAttribute("list5");
if (list5 == null) {
  list5 = new java.util.ArrayList();
  pageContext.setAttribute("list5");
}
 --%>
<%
list5.add("홍길동");
%>
<%=list5.get(0) %>

-----------------------------------------------------
<%-- type만 지정하기 --%>
<%-- 테스트 하려면 아래 태그를 주석 풀라! 
<jsp:useBean id="list6" type="java.util.ArrayList"/>
--%>

<%-- 
해당 아이디를 가진 객체를 찾지 못하면 예외가 발생한다. 객체를 생성하지 않는다.
java.util.List list6 = (java.util.List)pageContext.getAttribute("list6");
if (list6 == null) {
  throw new InstantiationExeption();
}
 --%>

-----------------------------------------------------
<%-- class에 인터페이스 지정하기
. 오류가 발생한다.
. 이유?
class 속성은 객체를 찾을 때 사용할 뿐만 아니라, 새로 객체를 생성할 때 클래스 이름을 사용한다.
그런데 클래스가 아니라 인터페이스라면 객체를 생성할 수 없기 때문에 오류가 발생한다.
 --%>
<%-- 테스트 하려면 다음 태그의 주석을 제거하라! 
<jsp:useBean id="list7" class="java.util.List"/>
--%>































  
  
  
  
  
  
  
  
  
  
  
  
  
  
  