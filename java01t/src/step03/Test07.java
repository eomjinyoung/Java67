package step03;

/*
 * 비트 연산자
 * - &, |, ~, ^
 * & - 비트 단위로 AND 연산을 수행. 
 * | - 비트 단위로 OR 연산을 수행.
 * ~ - 모든 비트를 반대 값으로 변경.
 * ^ - 비튼 단위로 XOR 연산을 수행. 비트의 값이 다르면 1, 같으면 0.
 * 
 * 비트 연산을 사용하는 경우?
 * - 그래픽 처리 애플리케이션을 만들 때 사용한다.
 * - 하나의 이미지에 다른 이미지를 겹치는 경우.
 * - 마스크를 입히는 경우. 
 */
public class Test07 {

  public static void main(String[] args) {
    int v1 = 13;
    int v2 = 5;
    
    System.out.printf("%x, %x, %x, %x\n", 
        v1 & v2, v1 | v2, ~v1, v1 ^ v2); 

  }

}
