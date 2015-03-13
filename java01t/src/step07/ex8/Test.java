package step07.ex8;

//Garbage Collector
//- Garbage? 레퍼런스가 없는 인스턴스. 사용할 수 없는 메모리.
//- Garbage 여부 파악하는 방법?
//  JVM은 참조 테이블(reference table)이라고 불리우는 
//  인스턴스를 참조하는 레퍼런스의 증가 여부를 관리 테이블이 있다.
//  참조 테이블에서 수치가 0인 인스턴스가 가비지가 된다.
//
//- Garbage의 처리?
//  가비지 컬렉터에 의해 메모리에서 해제된다.
//
//- 가비지 컬렉터의 동작?
//  .인스턴스를 새로 만들려고 할 때 메모리가 부족하면,
//  .CPU가 한가할 때, Idle Time.
//
//
public class Test {
  
  public static void main(String[] args) {
    int[] a = new int[100];
    int[] b = a;
    int[] c = new int[100];
    a = c;
    b = c;
    a = null;
    b = null;
    c = null;
    
    //참고,
    //이렇게 더 이상 가리킬 수 없는 메모리: Garbage라고 한다.
    // 프로그래밍 언어론: Dangling object
    // 주소를 몰라서 사용할 수 없는 메모리
    
    
    // Dangling Pointer
    // ex)C
    // byte* p = malloc(100);
    // free(p);
    // p[0] = 10; //해제한 메모리에 접근해서 값을 넣으려 하면, 오류!
    //            // access violation 오류! 블루스크린!
    // p 변수처럼 존재하지 않는 메모리를 가리키는 변수를 => dangling pointer
    // 유효하지 않는 주소를 가리키는 레퍼런스
    
    
    //주소를 가지지 않는 레퍼런스를 사용하려 할 때, 오류 발생!
    //NullPointerException 오류!
    a[0] = 10;
    
  }

}










