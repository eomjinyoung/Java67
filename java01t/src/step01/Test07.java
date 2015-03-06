package step01;

//배열
//- 같은 종류의 메모리를 여러 개 준비할 경우 사용
//- 문법
//  new 자료형[개수];
public class Test07 {

  public static void main(String[] args) {
    //1. 배열 사용 전
    int kor, eng, math, sci, soc;
    
    kor = 100;
    eng = 100;
    math = 100;
    sci = 100;
    soc = 100;
    
    //2. 배열 사용 후
    //v1 - 배열의 주소를 받을 레퍼런스
    int[] score = new int[5];
    
    score[0] = 100;
    score[1] = 100;
    score[2] = 100;
    score[3] = 100;
    score[4] = 100;
    //score[5] = 100; //없는 인덱스 지정하면 오류! ArrayIndexOutOfBoundsException
    
    //3. 배열 선언 방법 2: 배열 선언 + 초기 값 설정 
    int[] score2 = new int[]{100,90,80,70,60};
    
    System.out.printf("%d,%d,%d,%d,%d\n", 
        score2[0],score2[1],score2[2],score2[3],score2[4]);

    //4. 배열 선언 방법 3: 배열 선언 + 초기 값 설정 <= new 명령 생략가능!
    int[] score3 = {100,90,80,70,60};
    
    
  }

}










