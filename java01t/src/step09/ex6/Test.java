package step09.ex6;

// 서브 클래스 로딩 시 수퍼 클래스의 로딩을 이해
// ScoreEx를 로딩할 때 Score는 언제 로딩하는가?

public class Test {

  public static void main(String[] args) {
    //Score 클래스 로딩됨
    //new Score(); 
    
    //ScoreEx 클래스 로딩됨
    //클래스 로딩 순서
    //1) ScoreEx 클래스의 상위 클래스 조사 
    //2) Score 클래스 로딩 
    //3) ScoreEx 클래스 로딩
    // 결론: 수퍼 클래스부터 로딩된다.
    new ScoreEx();

  }

}
