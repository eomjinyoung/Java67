package step09.ex5;

import step09.ex3.Score2;

// 다형성의 오버라이딩 적용!
// => Score2의 print() 메서드 재정의 
// => @Override 애노테이션을 적용 : 오버라이딩의 유효성 검사를 컴파일러에게 요청한다.
public class ScoreEx extends Score2 {
  protected int soc; //사회
  protected int sci; //과학

  //오버라이딩
  @Override
  public void print() {
    //kor, eng, math, sum, aver 는 private 접근 제어를 갖기 때문에
    //자식 클래스에서 직접 접근이 불가능하다.
    //쓰기 불편하다. 
    //=> 그래서 보통 자식 클래스는 접근할 수 있도록 protected로 선언한다.
    //=> Score 클래스 대신 이 예제를 위해 새로 만든 ex3.Score2를 상속 받는다.
    System.out.printf("%s, %d, %d, %d, %d, %d, %d, %.1f\n",
        name, kor, eng, math, soc, sci, sum, aver);
  }
  
  //오버라이딩 
  //총점과 평균을 구하는 메서드도 이 클래스에 맞게끔 재정의한다.
  @Override
  public void compute() {
    sum = kor + eng + math + soc + sci;
    aver = sum / 5f;
  }
  
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













