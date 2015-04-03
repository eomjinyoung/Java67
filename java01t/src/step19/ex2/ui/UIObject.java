package step19.ex2.ui;

import java.util.HashMap;

//인터페이스 적용
//- UIObject는 서브 클래스에게 상속해 줄 어떤 것도 없다.
//- 단지 MemberConroler이 호출하는 메서드에 대해 규칙만 정의했다.
//- 따라서, UIObject는 추상 클래스로 정의하기 보다 인터페이스로 정의하는 것이 좋다.
// 
//- 인터페이스를 만다면 항상 누구와 누구의 호출 규칙인지 파악하라!
//  호출자가 누구며, 호출 당하는 자가 누구인지 확인하라!
//
//- 다음 UIObject는 MemberControl과 UIObject 사이의 호출 규칙이다.
//  호출자: MemberControl
//  피호출자: UI 클래스
// 
// 문법
// - class 클래스명 implements 규칙명 { ... }
// - 인터페이스를 구현하는 클래스는 인터페이스에 선언된 모든 메서드를 만들어야 한다.
// 
public interface UIObject {
  
  // 인터페이스에 선언하는 메서드는 반드시 public abstract여야 한다.
  // 안 적으면 컴파일러에서 자동으로 추가한다.
  // public 대신 다른 접근자는 사용 불가! 왜? 규칙이잖아. 규칙은 공개되어야 하잖아.
  // 규칙은 구현해서는 안된다. 반드시 추상 메서드여야 한다.
  /*public abstract*/ void execute(HashMap<String,Object> paramMap);
}










