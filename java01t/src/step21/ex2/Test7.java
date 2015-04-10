package step21.ex2;

//실습 목표: 이너 클래스와 아웃터 클래스의 교류!
// => 중첩 클래스도 바깥 클래스의 멤버이기 때문에 바깥 클래스의 다른 멤버에 접근할 수 있다.
// 
public class Test7 {
  
  int value;
  int score;
  int level;
  
  class InnerClass {
    /* 인스턴스 멤버 이너 클래스는 바깥 클래스의 인스턴스 주소를 받기 위한 특별한 변수를 갖고 있다.
     * "바깥클래스명.this"라는 변수이다.
     * 바깥 클래스의 메서드에서 이너 클래스의 인스턴스를 만들 때,
     * "바깥클래스명.this" 변수에 인스턴스를 만들 당시의 바깥 클래스 인스턴스 주소를 저장한다.  
     */
   
    public void setValue(int v) {
      //Test7.this.value = v;
      //이너 클래스의 인스턴스 변수 이름이나 메서드의 로컬 변수 이름과 같지 않다면,
      //다음과 같이 Test7.this 명령을 생략할 수 있다.
      value = v;  //바깥 클래스의 인스턴스 변수에 접근한다. 가능한가?
    }

    /* 바깥 클래스의 인스턴스 변수 이름과,
     * 이너 클래스의 인스턴스 변수 이름과,
     * 메서드의 로컬 변수 이름이 같을 때!
     */
    int score;
    
    public void setScore(int score) {
      score = 100; // 로컬 변수를 가리킨다.
      
      this.score = 100; // 이너 클래스의 인스턴스 변수를 가리킨다.
      
      //바깥 클래스의 인스턴스 변수는 어떻게 가리키는가?
      Test7.this.score = 100; 

      //this.level = 200; // 그냥 this는 항상 그 메서드가 소속된 이너 클래스를 가리킨다.
      Test7.this.level = 200; // 바깥 클래스의 인스턴스 변수는 바깥 클래스 이름으로 
                              // 분명하게 가리켜야 한다.
    }
   
  }
  
  public void m01(int param) {
    InnerClass p = new InnerClass(); // 중첩 클래스의 인스턴스 생성 
    p.setValue(param);
    
    System.out.println(this.value); // 바깥 클래스의 value 인스턴스 변수 값 출력
  }
  
  public void m02() {
    this.value = 3000;
  }
  
  public static void quiz() {
    //InnerClass p = new InnerClass(); // 왜 오류가 나는가?
    //this.m02(); // 스태틱 메서드는 this라는 인스턴스 주소를 받는 변수가 없다. 
  }
  
  public static void main(String[] args) {
    Test7 r1 = new Test7();
    Test7 r2 = new Test7();
    
    //Test7.m01(2000); //인스턴스 멤버는 인스턴스가 있어야만 사용할 수 있다.
    
    r1.m01(1000);
    r2.m01(2000);

  }

}












