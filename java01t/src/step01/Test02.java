package step01;


// short, int, long 변수 선언
// 자바에서 정수를 표현하는 방법: Literal(리터럴)
// 1) 10진수: 13
// 2) 8진수: 015, 0_15
// 3) 2진수: 0b1010, 0B1010, 0b11110000, 0b1111_0000
// 4) 16진수: 0xac00, 0Xac00, 0xAC00, 0XAC00
//
// 리터럴에 크기 지정
// 1) int 크기의 정수값: 10
// 2) long 크기의 정수값: 10L, 10l
// 3) float 크기의 부동소수점값: 10f, 10F
// 4) double 크기의 부동소수점값: 10
//
// 자바 기본 자료형
// 1) 정수: byte(1), short(2), int(4), long(8)
// 2) 부동소수점: float(4), double(8)
// 3) 논리: boolean(1)
// 4) 문자: char(2)


public class Test02 {

  public static void main(String[] args) {
    short v1 = -32768;
    short v2 = 32767;
    
    //8진수 표현
    int v3 = 015;
    int v4 = 0_15;
    System.out.println(v3);
    System.out.println(v4);
    
    //16진수 표현
    //수는 대/소문자 구분 안함.
    int v5 = 0xd; //소문자 x를 주로 사용
    int v6 = 0Xd;
    int v7 = 0xD;
    int v8 = 0XD;
    System.out.println(v5);
    
    //2진수 표현
    int v9 = 0b1101;
    int v10 = 0B1101;
    
    int v11 = 0b1010110000000000; //0xAC00
    int v12 = 0b1010_1100_0000_0000; //0xAC00
    
    System.out.println(v9);
    System.out.println(v10);
    System.out.println(v11);
    System.out.println(v12);
    
    //리터럴에서 크기 지정 방법
    // 32비트 정수 표기법
    int v13 = 10;
    long v14 = 10;
    
    //64비트 정수 표기법
    long v15 = 10L;
    long v16 = 10l;
    
    // 오류! 64비트 값을 32비트 메모리에 담을 수 없다. 
    //int v17 = 10L;
    
    //16비트나 8비트 정수는 표기법이 없다.
    
    //부동소수점 리터럴 표기법
    //32비트 부동소수점 값
    float v17 = 3.14f;
    float v18 = 3.14F;
    
    //64비트 부동소수점 값
    double v19 = 3.14; //주로 사용
    double v20 = 3.14D;
    double v21 = 3.14d;
    //float v22 = 3.14; //오류!
    //float v23 = 3.14d; //오류!
    
    
    //논리 값 표기법: true, false
    boolean v24 = true;
    boolean v25 = false;
    
    //주의! C언어처럼 직접 0과 1을 넣을 수는 없다.
    //boolean v26 = 1; //오류!
    //boolean v27 = 0; //오류!
    
    // 논리 값을 일반 정수 변수에 넣을 수 없다.
    //int v28 = true; //오류!
    //int v29 = false; //오류!
    
    // 문자 표기법 : 유니코드 값을 숫자로 표현하면 된다.
    char v30 = 44032;
    char v31 = 0xAC00;
    System.out.println(v30);
    System.out.println(v31);
    
    //특수 도구: 문자를 유니코드 값으로 바꿔주는 연산자
    //작은 따옴표!!! 
    char v32 = '가';
  }

}
