package step03;

/*
 * 비트 이동 연산자
 * << - 왼쪽 이동. 빈 자리는 0으로 채움. 곱하기 2와 동일한 결과를 준다.
 * >> - 오른쪽 이동. 빈자리는 부호 비트로 채움. 양수이면 0, 음수이면 1. 
 * >>> - 오른쪽 이동. 빈자리를 무조건 0으로 채움. 음수를 이동시키면 양수가 된다.
 */
public class Test05 {

  public static void main(String[] args) {
    int v1 = 1784302138; // = 0x6a5a4a3a;
    
    System.out.printf("%d, %x\n", v1, v1);
    System.out.printf("%x, %08x, %08x\n", 
        v1 << 4, v1 >> 4, v1 >>> 4);

    v1 = -1784302138; 
    System.out.printf("%d, %x\n", v1, v1);
    System.out.printf("%x, %08x(%2$d), %08x(%3$d)\n", 
        v1 << 4, v1 >> 4, v1 >>> 4);
    
    
    // 왼쪽 비트 이동 연산자는 값 * 2^이동비트수 와 결과가 같다.
    int v2 = 345;
    System.out.printf("%d, %d\n", v2 * 2, v2 << 1);
    System.out.printf("%d, %d\n", v2 * 8, v2 << 3);
    
  }

}










