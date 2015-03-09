package step04;

/*
 * 반복문
 * - 특정 명령어를 조건에 따라 반복 실행하고 싶을 때 사용
 * 
 * while (조건) {} // 조건이 참인 동안 계속 반복.
 * do {} while (조건) // 조건이 참인 동안 계속 반복. 무조건 한 번은 실행!
 * for (초기화문장; 조건; 증가문) {} //조건이 참인 동안 계속 반복. 
 *   인덱스를 기준으로 반복할 때 적합
 * 
 * for (변수 : 배열 또는 Collection 인스턴스) {} //배열의 항목을 모두 돌 때까지 반복
 */
public class Test03 {
 public static void main(String[] args) {
   int index = 1;
   int result = 1;

   while (index <= 5) {
     result *= index;
     index++; // 반복문을 탈출할 수 있는 코드를 넣어야 한다.
   }
   System.out.println(result);
   
   index = 1;
   result = 1;
   while (index <= 5) {
     result *= index++; //후위 연산자를 이용! 가독성이 떨어짐. 실수할 가능성 높음.
   }
   System.out.println(result);
   
   //do ... while
   //최소 한번은 실행!
   index = 1;
   result = 1;
   do {
     result *= index;
     index++;
   } while (index <= 5);
   System.out.println(result);
   
   //for
   //인덱스를 가지고 반복을 처리할 때. 예) 배열 데이터 처리할 때
   result = 1;
   for (int i = 1; i <= 5; i++) 
     result *= i;
   
   //System.out.println(i); //i는 for문 안에서 선언되었기 때문에 바깥에서 사용할 수 없다.
   System.out.println(result);
   
   //for (; 조건; 증가) : 초기화문을 생략할 수 있다.
   int k = 1;
   result = 1;
   for (; k <= 5; k++)  
     result *= k;
   System.out.println(result);
   
   //for (; 조건; ) : 증가문을 생략할 수 있다.
   //=> 궁시렁! 이렇게 사용할거면, while을 쓰지 왜 for문을 쓰냐!
   k = 1;
   result = 1;
   for (; k <= 5;) {  
     result *= k;
     k++;
   }
   System.out.println(result);
   
   //for (;;) : 무한 반복!
   // 대신 for 문 블록 안에 종료 조건을 넣는다.
   k = 1;
   result = 1;
   for (;;) { // ==> while (true) {
     result *= k;
     k++;
     if (k > 5) 
       break; // 자신이 소속된 반복문 탈출!
   }
   System.out.println(result);
   
   //for (변수:배열 또는 컬렉션 객체)
   int[] scores = {100, 90, 100, 80, 100};
   int sum = 0;
   
   //이전 방식
   for (int i = 0; i <= 4; i++) //조건의 끝을 명확하게 지정 
     sum += scores[i];
   System.out.printf("합계 = %d\n", sum);
   
   //실무에서는 다음과 같이 조건을 적는다.
   sum = 0;
   for (int i = 0; i < 5; i++) //조건의 값이 개수를 나타냄. 적응하면 오히려 쉽다. 
     sum += scores[i];
   System.out.printf("합계 = %d\n", sum);
   
   //배열의 개수를 직접 적는 대신, 계산한 값을 넣는다.
   //배열변수.length ---> 배열의 개수를 알려준다.
   sum = 0;
   for (int i = 0; i < scores.length; i++)  
     sum += scores[i];
   System.out.printf("합계 = %d\n", sum);
   
   //추가된 문법: 배열을 전문적으로 사용하는 for문
   //배열의 끝까지 반복할 경우 적합하다.
   //단, 몇 번째인지 알려면 인덱스를 별도로 관리해야 한다.
   sum = 0;
   for (int score : scores) { //scores 배열에서 꺼낸 값은 score에 저장된다.
     sum += score;
   }
   System.out.printf("합계 = %d\n", sum);
   
   sum = 0;
   int count = 0;
   for (int score : scores) { //scores 배열에서 꺼낸 값은 score에 저장된다.
     sum += score;
     
     count++; //따로 반복 인덱스를 관리해야 하므로 불편한 점도 있다.
     
     if (count == 3) 
       break;
   }
   System.out.printf("합계 = %d\n", sum);
   
 }
}
























