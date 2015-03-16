package step09.ex4;

// 상속 문법 적용
// - 기존의 Score 클래스를 상속 받는다.
// - 사회와 과학 점수를 저장할 인스턴스 변수를 추가한다.
//
// import 
// 다른 패키지의 클래스를 사용하려면, 
// 반드시 패키지 이름을 포함하여 클래스 이름을 작성해야 한다.
// => 좀 더 쉽게 처리하는 방법
//    import 명령을 사용하여 클래스의 정보를 컴파일러에게 알려준다.
//    그러면, 컴파일러는 컴파일 할 때 그 정보를 바탕으로 클래스를 찾는다.
//    그리고 클래스를 완전한 이름을 변경한다.
import step09.ex3.Score;

// 다음과 같이 클래스가 소속되어 있는 패키지명만 적어도 된다.
// - 이런 방식으로 표현된 import 문이 많다면,
//   1) 컴파일러는 해당 클래스를 찾기 위해 일일이 패키지들을 뒤져야 한다.
//      => 컴파일 속도가 저하되는 문제가 있다. 
//   2) import를 봐서는 해당 클래스가 어떤 패키지에 있는지 알 수 없다.
// 결론, 가능한 위의 방식처럼 클래스 이름까지 명확하게 지정하라!
// 그게 소스 코드를 읽는데 도움이 된다.
/*
import step08.ex3.*;
import java.util.*;
import java.net.*;
*/

//질문: 
//import 문을 작성할 때 클래스 이름까지 지정한다면,
//클래스 개수가 많을 때 import문도 많아지는 문제가 있지 않느냐?
//답변:
//import 문을 많이 작성한다고, 바이트코드가 커지는 것은 아니다.
//import 문은 바이트코드에 포함되지 않는다.
//어차피 컴파일할 때 각각의 단축 클래스 이름은 패키지 명을 포함한 이름으로 변경되기 때문이다.

// 용어정리!
// 상속을 해주는 클래스 => super, parent 클래스
// 상속을 받는 클래스 => sub, child 클래스 
//
public class ScoreEx extends /*step09.ex3.*/Score {
  //추가할 인스턴스 변수 선언
  protected int soc; //사회
  protected int sci; //과학
  
  //인스턴스의 값을 꺼내고 저장할 getter와 setter 정의
  public int getSoc() {
    return soc;
  }
  public void setSoc(int soc) {
    this.soc = soc;
    compute();
  }
  public int getSci() {
    return sci;
  }
  public void setSci(int sci) {
    this.sci = sci;
    compute();
  }
  
  //Score에서 name을 protected로 선언했기 때문에 Test에서 접근할 수 없다.
  //Test 클래스에서 name 값을 설정할 수 있도록 셋터/겟터 추가한다.
  //protected 이기 때문에 자식 클래스에서는 접근 가능하다.
  public String getName() {
    return name; 
  }
  public void setName(String name) {
    this.name = name;
  }
  
}













