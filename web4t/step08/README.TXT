[8단계:  ContentNegotiatingViewResolver 사용하기]
- 리턴 값에 따라 ViewResolver를 선택한다.
1) 프론트 컨트롤러의 스프링 설정 파일 변경
- 다음 빈 설정을 추가한다.
<bean class="org.springframework.web.servlet.view.ContentNegotiatingViewResolver">
    ...
</bean>

2) 페이지 컨트롤러 변경
- 각 메서드의 리턴 값을 Object로 바꾼다.
- 데이터를 저장한 객체를 바로 리턴한다.

3) Access-Control-Allow-Origin 헤더 추가
- JsonFilter 클래스를 작성한다.