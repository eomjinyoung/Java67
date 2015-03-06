package step02;

//형식을 갖춰 출력하기
//printf(), format()
//1)printf("형식 문자열", 변수, 변수, ...)

public class Test02 {

  public static void main(String[] args) {
    //printf(포맷, 값들...)
    //포맷 문법: %[argument_index$][flags][width][.precision]conversion
    //1. conversion(대소문자 모두 허용)
    // b - boolean
    // h - 16진수
    // s - 문자열
    // c - 유니코드 문자
    // d - 10진수
    // o - 8진수
    // x - 16진수
    // n - 줄 바꿈
    System.out.printf("국어: %d\n영어: %d\n", 100, 90);
    System.out.printf("%d, %o, %x, %h%n", 13, 13, 13, 13);
    System.out.printf("%s, %c, %d%n", "오호라", 0xAC00, 0xAC00);

    //
  }

}








