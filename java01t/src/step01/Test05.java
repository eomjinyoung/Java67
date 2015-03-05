package step01;

// 상수
//=> 한번 값을 설정하고 바꾸지 않는다면, 안전을 위해 
//   문법으로 아예 변경하지 못하게 만들라!
//문법
//final 자료형 상수명;
//- 상수 이름은 가능한 대문자로 하는 것이 좋다.
public class Test05 {

  public static void main(String[] args) {
    //원의 넓이를 구하자.
    //파이 값은 바꾸지 말아야 하기 때문에, 바꿀 수 없도록 문법으로 제약을 가하자!
    final float PI = 3.14159f;
    //final float PI;
    //PI = 3.14159f;
    
    //반지름 
    float r = 20.5f;
    
    //원의 넓이
    double area = r * r * PI;
    
    System.out.println(area);
    
    //PI = 3.55f;
    r = 14f;
    area = r * r * PI;
    System.out.println(area);
  }

}










