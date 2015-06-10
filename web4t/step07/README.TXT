[7단계: Gson 라이브러리를 이용하여 JSON 출력하기]
- JSON 자바 라이브러리 이용: Google JSON(Gson)
1) www.mvnrepository.com에서 "Gson" 검색한다.
2) build.gradle 파일에 의존 라이브러리 정보를 추가한다.
3) Run As > build...
   clean
   eclipse
   build
4) BoardController의 리턴 값을 JSON 형식의 문자열을 리턴하도록 변경한다.
5) nodejs에서 작업했던 board.html, board.js를 가져와서 사용한다.   