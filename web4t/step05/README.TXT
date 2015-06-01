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
                              

[세션]
- 사용자 별로 데이터를 관리하고 싶을 때 사용
- 요청 정보에 세션 ID(쿠키)가 없으면, HttpSession 객체를 생성한다.
- 응답할 때 생성한 세션의 ID를 쿠키로 보낸다.
- 세션 ID 쿠키는 timeout을 지정하지 않는다. => 웹브라우저 종료 시 삭제된다.
- 쿠키는 같은 브라우저끼리 공유하기 때문에,
  단 한 브라우저라도 실행하고 있으면 세션은 유지된다.
- 세션에 타임아웃을 지정하면,
  타임아웃 될 때까지 요청이 없으면, 세션은 무효화된다.
- 사용자 별로 화면과 화면 사이에 계산 결과나 입력 값을 공유할 때 사용한다.
- 서버쪽 보관소이기 때문에, 객체를 저장할 수 있다.
- 세션의 삭제
  1) 서버쪽에 생성되는 객체이기 때문에, 서버가 종료되면 세션 객체도 삭제된다.
  2) 세션을 사용하는 시점에 타임아웃 되었는지 검사하여, 타임아웃 되었으면 삭제한다.   

[로그인,로그아웃 처리]
1) 로그인 폼 만들기
- /WEB-INF/views/auth/login.jsp

2) 로그인,로그아웃 처리 페이지 컨트롤러 만들기
- ...web.AuthController.java

3) 로그인,로그아웃 DAO 만들기
- ...dao.UserDao.java









  

