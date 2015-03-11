package step06.ex4;

// default 접근 범위를 갖는 메서드를 호출할 수 있을까?
// - 같은 패키지 소속이 아니면 호출할 수 없다.
public class Test {

  public static void main(String[] args) {
    // step06.ex3.Calculator의 plus()는 default 접근 범위를 갖는다.
    // 따라서, 다른 패키지 소속 클래스는 호출할 수 없다. 
    //int result = step06.ex3.Calculator.plus(10, 20);

    // step06.ex3.Calculator2의 메서드 호출
    // - 메서드들이 public 접근 범위를 갖기 때문에 호출할 수 있다.
    int result2 = step06.ex3.Calculator2.plus(10, 20);
  }

}
