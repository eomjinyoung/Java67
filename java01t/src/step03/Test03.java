package step03;

// 명시적 형변환과 암시적 형변환
// 형변환? 연산을 수행하기 위해 피연산자의 자료형을 일치시키는 것.
// - 값을 임의의 자료형으로 변환할 필요가 있을 때 사용
// - 임시 메모리를 내부적으로 준비한 후, 변환 값을 저장한다.  
// 문법
// - (변환할자료형)변수 또는 상수 또는 리터럴
// 
// 암시적 형변환: JVM이 실행 중에 계산을 수행하기 위해 내부에 정한 규칙에 따라 형변환시키는 것.
// byte,short -> int -> long -> float -> double
public class Test03 {

  public static void main(String[] args) {
    int a = 5;
    int b = 2;
    
    //형변환 전
    float result = a / b;
    System.out.println(result);
    
    //형변환 후
    result = (float)a / (float)b;
    System.out.println(result);
    
    
    //암시적 형변환
    byte bb = 10;
    short ss = 20;
    int ii = 30;
    long ll = 40;
    float ff = 50.5f;
    double dd = 60.5;
    
    int result2 = bb + ss; // 암시적 형변환: (int)bb + (int)ss
    int result3 = bb + ii; // (int)bb + ii
    
    //int result4 = bb + ll; // (long)bb + ll => 결과가 long 형이다. 오류!
    long result4 = bb + ll;  // result4를 long으로 선언하라!
    
    //long result5 = ii + ll * ff; //최종 계산 결과는 float. 오류! 
    // ii + (float)ll * ff
    // ii + (float)계산결과
    // (float)ii + (float)계산결과 => (float)최종계산결과 
    float result5 = ii + ll * ff;
    
    //다음 코드를 암시적 형변환과 명시적 형변환을 섞어서 처리
    //result = (float)a / (float)b;
    result = a / (float)b;
    result = (float)a / b;
  }

}











