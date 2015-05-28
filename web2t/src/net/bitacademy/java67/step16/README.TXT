[파일 업로드]
1. HTTP 요청 프로토콜에 대한 이해
- POST 방식 요청이다.
- multipart/form-data 라는 특별한 형식으로 서버에 보낸다.

2. HTML 폼 작성
- /WebContent/step16/form.html
- <form> 태그의 enctype 속성 값이 multipart/form-data 이어야 한다.
- 만약 enctype 속성이 기본 값으로 설정된 경우,
  서버에 보내는 데이터는 단지 파일 이름 뿐이다. 파일의 내용을 보내지 않는다.

3. 멀티파트 데이터 꺼내기
1) www.apache.org > commons.apache.org > fileupload > 다운로드 한다.
  
 

