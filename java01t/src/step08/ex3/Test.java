package step08.ex3;

//스태틱 블록을 사용하여 클래스가 로딩될 때 초기화시키는 작업을 수행하자!
public class Test {

  public static void main(String[] args) {
    //1. 인스턴스를 생성
    new Score();
    
    //두 번째 인스턴스 생성부터는 스태틱 블록을 실행하지 않는다. 이유?
    //클래스가 이미 로딩되었기 때문에.
    new Score();
    new Score();
    
  }

}
