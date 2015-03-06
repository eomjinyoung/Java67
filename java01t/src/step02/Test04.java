package step02;

//키보드로부터 한 줄 읽기
public class Test04 {

  public static void main(String[] args) {
    java.util.Scanner keyScan = new java.util.Scanner(System.in);
    
    //키보드로부터 한 줄 읽기
    String s1 = keyScan.nextLine();
    String s2 = keyScan.nextLine();
    
    System.out.println(s1);
    System.out.println(s2);
    
    //숫자 읽기
    //한 토큰(단어)을 읽어서 숫자로 바꾼 다음에 리턴한다.
    //리턴? 작업한 결과물을 그 자리에 놓는다.
    int kor = keyScan.nextInt();
    int eng = keyScan.nextInt();
    int math = keyScan.nextInt();
    int sum = kor + eng + math;
    System.out.println(sum);
    
    keyScan.close();

  }

}
