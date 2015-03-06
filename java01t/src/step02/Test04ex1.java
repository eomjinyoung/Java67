package step02;

public class Test04ex1 {

  public static void main(String[] args) {
    //이름? 홍길동
    //국어? 100
    //영어? 90
    //수학? 80
    //총점은 270입니다. 평균은 90.0입니다.
    
    java.util.Scanner sc = new java.util.Scanner(System.in);
    
    System.out.print("이름? ");
    String name = sc.nextLine();
    System.out.print("국어? ");
    int kor = sc.nextInt();
    System.out.print("수학? ");
    int math = sc.nextInt();
    System.out.print("영어? ");
    int eng = sc.nextInt();
    
    int sum = kor + math + eng;
    float avg = sum / 3;
    
    System.out.printf("총점은 %d 입니다. 평균은 %.1f 입니다", sum, avg);
    
    sc.close();
  }

}
