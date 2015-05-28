package net.bitacademy.java67.step16;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/* 실습 목표: multipart/form-data 형식으로 넘어온 값 꺼내기 
 * - 멀티파트 형식으로 넘어온 파라미터 값은 request.getParameter() 메서드로 꺼낼 수 없다.
 * - 멀티파트 형식을 해석하여 별도로 추출해야 한다.
 * - 멀티파트 형식의 데이터 추출하기 => apache 사이트에서 제공한 오픈소스 API를 사용하라! 
 */
@WebServlet("/step16/fileUpload02")
public class FileUploadServlet02 extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void service(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    /* 아래와 같이 일반적인 방법으로는 멀티파트 데이터를 꺼낼 수 없다.*/
    /*
    String name = request.getParameter("name");
    int age = Integer.parseInt(request.getParameter("age"));
    String file = request.getParameter("file");
  
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.printf("%s, %d, %s\n", name, age, file);
    */
    
    // 출력 준비!
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    //1) 각 파트의 정보를 FileItem 객체에 담아주는 팩토리를 준비한다.
    //- DiskFileItemFactory 팩토리: 파일을 디스크에 임시 저장한다.
    //- 기본으로 제공되는 것 외에 개발자가 파일을 클라우드 스토리지에 보관하도록 
    //  팩토리 클래스를 제작하여 사용할 수 있다.
    DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
    
    //2) 멀티파트 데이터를 분석하는 객체를 준비한다.
    // - ServletFileUpload 객체가 멀티파트 데이터를 분석하면,
    //   DiskFileItemFactory 객체가 분석된 각 파트의 정보를 FileItem 객체에 담는다.
    ServletFileUpload multipartDataAnalyzer = 
                      new ServletFileUpload(fileItemFactory);
    
    try {
      //3) 요청 데이터를 분석할 것을 지시한다.
      List<FileItem> items = multipartDataAnalyzer.parseRequest(request);
      
      //4) 각 FileItem 객체에서 요청 파라미터 값을 추출한다.
      HashMap<String,String> paramMap = new HashMap<String,String>();
      
      
      for (FileItem fileItem : items) {
        if (fileItem.isFormField()) { // 일반적인 폼 입력 항목이냐?
          out.printf("%s, %s\n", 
              fileItem.getFieldName(), fileItem.getString("UTF-8"));
          
        } else { // 파일일 경우?
          out.printf("%s, %s\n", 
              fileItem.getFieldName(), fileItem.getName());
        }
      }
      
    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}
















