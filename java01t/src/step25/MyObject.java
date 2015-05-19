package step25;

//다음과 같이 default 값이 없는 속성은 반드시 값을 지정해야 한다.
//@MyAnnotation() // name 속성은 기본 값이 없기 때문에 값을 지정하지 않으면 오류이다.

//email은 default 값이 있기 때문에, 속성 값을 지정하지 않아도 된다.
//@MyAnnotation(name="홍길동")

//물론, email 속성까지 지정해도 된다.
@MyAnnotation(name="홍길동",email="hong@test.com")
public class MyObject {

}
