package step21.ex2;

// 실습 목표: 익명 이너 클래스 만들고 사용하기

public class Test2 {

  //익명 이너 클래스
  Object obj = new Object() {};
  
  public void m() {
    //익명 이너 클래스
    Object obj2 = new Object() {};
    
  }
  
  public static void main(String[] args) {
    // 0단계: 익명 이너 클래스를 원초적으로 만들어 보자!
    /*
    class  extends Object { 
      public void hello() {
        System.out.println("안녕~~");
      }
    }*/
    
    // 1단계: 클래스 이름이 없기 때문에 클래스 정의하자마자 즉시 인스턴스 생성
    /*
    new class  extends Object { 
      public void hello() {
        System.out.println("안녕~~");
      }
    }*/
    
    // 2단계: 인스턴스를 즉시 생성하기 때문에 참조 변수가 있어야 한다.
    // 예) Object 참조 변수는 모든 클래스의 인스턴스를 가리킬 수 있다.
    /*
    Object obj = new class  extends Object { 
      public void hello() {
        System.out.println("안녕~~");
      }
    }
    */
    
    // 3단계: 할당 문이기 때문에 세미콜론이 있어야 한다.
    /*
    Object obj = new class  extends Object { 
      public void hello() {
        System.out.println("안녕~~");
      }
    };
    */

    // 4단계: 클래스 이름이 없기 때문에 class 명령 생략.
    /*
    Object obj = new extends Object { 
      public void hello() {
        System.out.println("안녕~~");
      }
    };
    */
    
    // 5단계: 클래스 이름이 없기 때문에 수퍼 클래스를 상속하는 extends 명령 생략
    /*
    Object obj = new Object { 
      public void hello() {
        System.out.println("안녕~~");
      }
    };
    */
    
    // 6단계: 인스턴스 생성 시 반드시 호출할 생성자를 지정해야 한다.
    // => 클래스에 생성자가 없기 때문에 수퍼 클래스의 생성자를 지정해야 한다.
    Object obj = new Object() {
      //클래스 이름이 없기 때문에 생성자를 만들 수 없다.
      //public () {
      //  
      //}
      public void hello() {
        System.out.println("안녕~~");
      }
    };
    
    

  }

}














