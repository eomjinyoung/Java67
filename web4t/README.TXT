[5단계: 파일 업로드, 쿠키, 세션 다루기]

[파일 업로드]
1. 입력폼 HTML 파일 생성
- /webapp/ex4/form.html

2. 페이지 컨트롤러 클래스 생성
- ...web.ex4.FileUploadController

3. 뷰 컴포넌트 생성
- /WEB-INF/views/ex4/FileUpload.jsp

4. 프론트 컨트롤러의 스프링 설정 파일에 멀티파트 데이터를 처리하는 객체를 등록한다.
<bean id="multipartResolver"
        class="org.springframework.web.multipart.commons.CommonsMultipartResolver">

    <!-- one of the properties available; the maximum file size in bytes -->
    <property name="maxUploadSize" value="100000"/>

</bean>

5. 의존 라이브러리 설정 추가
- build.gradle 파일
compile 'commons-fileupload:commons-fileupload:1.3.1'
- 그래들 빌드 수행
  1) 톰캣 서버 중지
  2) 빌드 수행
  clean
  eclipse
  build
  
[쿠키]
- 서버에서 클라이언트 쪽에 임시 보관하는 정보
- 클라이언트는 서버에 요청할 때마다, 서버에서 받은 쿠키를 요청 헤더에 포함해서 보낸다.
"클라이언트"                  "서버"
1) 요청 --------------------->
                              2) 쿠키를 생성
       <--------------------- 3) 응답 
         (응답 헤더에 쿠키를 포함)
         
4) 쿠키를 메모리 또는 임시 디렉토리에 보관함

5) 요청 ---------------------->      
       (요청 헤더에 쿠키를 포함)
                              6) 요청헤더에서 쿠키를 꺼내서 사용
                              











  

