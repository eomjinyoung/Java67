package step03;

/* 실습 목표: 비트 연산자 응용
 * 1) 여러 개의 on/off 값을 하나의 변수에 저장하는 방법. 
 *    특정 비트의 값이 1인지 아닌지 알아내는 방법
 *    => 비트 값으로 표현
 *    예) readable, writable, executable
 */
public class Test10 {

  public static void main(String[] args) {
    // 1. 일반 방식
    boolean readable = true;
    boolean writable = false;
    boolean executable = true;
    
    // 변수의 값 검사하기
    if (readable) System.out.print("readable ");
    if (writable) System.out.print("writable ");
    if (executable) System.out.print("executable ");
    System.out.println();
    
    // 2. 비트를 이용한 기법
    int auth = 0x4;
    auth = auth | 0x1;
    System.out.println(auth);
    
    // 변수의 값 검사하기
    // - 특정 비트의 상태를 검사하는 방법 => &(and) 연산자 사용하라!
    //   검사 비트를 1로 설정한 값을 대상 변수와 and 시킨다.
    //   그 결과가 and 시킨 값과 같다면 해당 비트는 1이다.
    if ((auth & 0x4) == 0x4) System.out.println("readable");
    if ((auth & 0x2) == 0x2) System.out.println("writable");
    if ((auth & 0x1) == 0x1) System.out.println("executable");
    

  }

}
