<%@page import="java.sql.Date"%>
<%@page import="net.bitacademy.java67.step13.BoardVo"%>
<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% // 자바 코드로 직접 객체를 만들어 PageContext에 보관하기
BoardVo board = new BoardVo();
board.setNo(1);
board.setTitle("제목이래요.");
board.setContent("내용이래요");
board.setViews(100);
board.setCreateDate(Date.valueOf("2015-05-14"));

pageContext.setAttribute("board1", board);
%> 

<jsp:useBean id="board2" scope="request" 
  class="net.bitacademy.java67.step13.BoardVo"/>
<jsp:setProperty name="board2" property="no" value="2"/>
<jsp:setProperty name="board2" property="title" value="제목2"/>
<jsp:setProperty name="board2" property="content" value="내용2"/>
<jsp:setProperty name="board2" property="views" value="200"/>
<jsp:setProperty name="board2" property="createDate" 
    value='<%=Date.valueOf("2015-05-14")%>'/>   

BoardVo board1 = (BoardVo)pageContext.getAttribute("board1");
out.write(board1.getNo());
==> ${pageScope.board1.no}

BoardVo board2 = (BoardVo)pageContext.getAttribute("board2");
out.write(board2.getNo());
==> ${pageScope.board2.no}   
------------------------------------------------------------------
[보관소를 지정하지 않았을 때]
${board1.title}
${board2.title}














   
   
   
   
   
   
   
   
   
   
   