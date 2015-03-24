package step16.ch03.ui;

import java.util.HashMap;

//추상 클래스 적용 후
//=> 의미:
//   1) 이 클래스를 직접 사용하지 말라! => 직접 사용을 제한한다.
//   2) 이 클래스의 기능을 상속 받아서 서브 클래스를 만들어 사용하라!

//추상 메서드 적용
//> 반드시 서브 클래스에서 execute()를 오버라이딩 하도록 강제한다.

public abstract class UIObject {
  
  // Controller에서 UI 객체에 대해 호출하는 메서드이다.
  // paramMap: 컨트롤러가 UI 객체에 값을 전달하거나, 
  //           UI 객체가 컨트롤러에게 값을 전달할 때 사용
  // => 서브 클래스는 이 메서드를 오버라이딩하여 사용해야 한다. 
  // 
  // 추상 메서드는 구현할 수 없다.
  public abstract void execute(HashMap<String,Object> paramMap);
}










