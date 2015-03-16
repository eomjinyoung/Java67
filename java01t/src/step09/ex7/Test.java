package step09.ex7;

// 서브 클래스의 인스턴스 생성 시 수퍼 클래스의 인스턴스 변수는?
// - 인스턴스 변수 생성 과정
//   1) 인스턴스 변수 준비(수퍼 -> 서브)
//   2) 인스턴스 초기화 문장 수행(수퍼 -> 서브)
//   4) 생성자 수행(수퍼 -> 서브) 

public class Test {

  public static void main(String[] args) {
    ScoreEx s1 = new ScoreEx();
    System.out.printf("%s|%d|%d|%d|%d|%d|%d|%.1f\n", 
        s1.name, s1.kor, s1.eng, s1.math, s1.soc, s1.sci, s1.sum, s1.aver);
    ScoreEx s2 = new ScoreEx();
    
    //인스턴스 생성 과정
    //1) Score 클래스 로딩 => static 블록 실행
    //
    //2) ScoreEx 클래스 로딩 => static 블록 실행
    //
    //3) Score의 인스턴스 변수 준비 => ScoreEx의 인스턴스 변수 준비
    // name(null)|kor(0)|eng(0)|math(0)|sum(0)|avr(0)|soc(0)|sci(0)
    //
    //4) Score의 초기화 문장 수행 => ScoreEx의 초기화 문장 수행
    // name("홍길동")|kor(0)|eng(0)|math(0)|sum(0)|avr(0)|soc(50)|sci(0)
    //
    //5) Score 생성자 실행 => ScoreEx 생성자 실행
    // name("임꺽정")|kor(0)|eng(0)|math(0)|sum(0)|avr(0)|soc(0)|sci(0)
    //
    //s2가 가리키는 인스턴스를 생성할 때는 Score, ScoreEx 클래스를 로딩하지 않는다.
    //이미 로딩되어 있으니까.
    //인스턴스 생성과정은 위의 s1과 같다.
    
  }

}















