package net.bitacademy.java67.step11;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 실습 목표: 공통 스타일을 원하는 서블릿에 포함됨.
 * 
 */

@WebServlet("/step11/commonStyle")
public class CommonStyleServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("    <style>");
    out.println("      body {");
    out.println("        font-size: small;");
    out.println("      }");
    out.println("      footer {");
    out.println("        border-top: 1px solid gray;");
    out.println("        margin: 10px 0;");
    out.println("        padding: 10px;");
    out.println("        background-color: yellow;");
    out.println("      }");
    out.println("    </style>");
  }
}













