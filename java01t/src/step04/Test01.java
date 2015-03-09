package step04;

// 흐름 제어문
// - 명령어 실행의 흐름을 조정하는 명령어
// - 조건문, 반복문
// 1. 조건문
// 1) if
// 2) if ~ else
// 3) if ~ else if ~ else
// 4) switch ~ case
public class Test01 {

  public static void main(String[] args) {
    boolean gender = false;
    
    // 조건이 참이면, 첫 번째 문장을 수행(세미콜론을 만날 때까지의 문장)
    if (gender == true) 
      System.out.println("여성");
      System.out.println("실행될까요?");
    
    // 조건에 대해 여러 명령을 실행하게 만들고 싶으면, 중괄호{}를 사용하라!
    if (gender == false) {
      System.out.println("남성");
      System.out.println("잘하자! 약하다고 생각말자!");
    }
    
    //if ~ else
    //주의! if ~ else는 한 문장이다.
    // else만 따로 사용할 수 없다. 반드시 if와 함께 사용해야 한다.
    int age = 28;
    if (age < 19) 
      System.out.println("청소년");
    else
      System.out.println("성인");
    
    
    // if와 else 사이에 다른 명령이 올 수 없다.
    /*
    if (age < 19) 
      System.out.println("청소년");
    
    int v2 = 20; //if와 else 사이에 다른 문장 삽입 불가! 오류!
    
    else
      System.out.println("성인");
    */
    
    // 여러 명령을 조건문에 지정하고 싶으면, 중괄호를 사용하라!
    if (age < 19) {
      System.out.println("청소년");
      System.out.println("이 나라의 희망");
    } else {
      System.out.println("성인");
      System.out.println("세금을 뽑기 좋은 밧데리의 역할자");
    }
    
    //if ~ else 를 여러 개 연결하기
    System.out.println("-------------------------");
    age = 44;
    if (age < 19) 
      System.out.println("청소년");
    else
      if (age >= 19 && age < 40)
        System.out.println("청년");
      else
        if (age >= 40 && age < 50)
          System.out.println("장년");
        else 
          if (age >= 50 && age < 60) 
            System.out.println("중년");
          else 
            System.out.println("노인");
    
    //위의 소스코드를 보기 좋게 정리하자!
    //자바는 else if라는 문법이 없다! 그냥 if ~ else의 연속일 뿐이다.
    age = 27;
    if (age < 19) 
      System.out.println("청소년");
    else if (age >= 19 && age < 40)
      System.out.println("청년");
    else if (age >= 40 && age < 50)
      System.out.println("장년");
    else if (age >= 50 && age < 60) 
      System.out.println("중년");
    else 
      System.out.println("노인");
  }

}












