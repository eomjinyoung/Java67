package step03;

//전위 연산자(++, --)
//++a, --a

public class Test04 {

  public static void main(String[] args) {
    int a = 10;
    
    //메모리의 들어 있는 값을 하나 증가시키기
    a = a + 1;
    //연산 순서
    //a = 10 + 1 <= a 변수의 값이 그 자리에 놓인다.
    //a = 11 <= 계산 결과를 a 변수에 저장한다.
    //주의! 배정연산자(=)는 r-value를 수행한 후 맨 마직막에 실행된다. 
    System.out.println(a);
    
    //용어 정리
    //l-value = r-value
    //l-value는 반드시 변수여야 한다.
    //r-value는 변수,상수,리터럴이 될 수 있다.
    
    //숫자가 1씩 증가하는 경우가 많다. => 1씩 증사시키는 문법이 필요
    //전위 연산자(pre-fix: ++a), 후위 연산자(post-fix: a++)연산자가 등장하였다.
    int b = 10;
    ++b; // b 변수에 들어 있는 값을 꺼내서 하나 증가시키고, 그 결과를 다시 b에 저장한다.
    System.out.println(b);
    
    int c = 10;
    c++; // c 변수의 값을 꺼낸다. 하나 증가시킨다. 다시 c에 저장한다. 
    System.out.println(c);
    
    //전위 연산자: 다른 연산을 수행하기 전에 값을 먼저 증가시키고 그 값을 그 자리에 놓는다.
    int d = 10;
    int result = ++d + ++d + ++d;
    //d = 11 
    //11 + ++d + ++d;
    //d = 12
    //11 + 12 + ++d;
    //d = 13
    //11 + 12 + 13 = 36
    System.out.println(result);
    
    //후위 연산자: 다른 연산을 수행하기 전에 값을 먼저 꺼내서 그 자리에 놓고, 값을 증가시킨다. 
    int e = 10;
    int result2 = e++ + e++ + e++;
    //10 + e++ + e++
    //e = 11
    //10 + 11 + e++
    //e = 12
    //10 + 11 + 12
    //e = 13
    System.out.println(result2);
    
    //전위 연산자의 우선 순위: *, / 보다 우선한다.   
    int f = 5;
    int result3 = ++f + ++f * ++f;
    //f = 6, 6 + ++f * ++f
    //f = 7, 6 + 7 * ++f
    //f = 8, 6 + 7 * 8
    System.out.println(result3);
    
    //괄호() 보다 우선한다.
    f = 5;
    result3 = ++f + (++f * ++f);
    //f = 6, 6 + (++f * ++f)
    //f = 7, 6 + (7 * ++f)
    //f = 8, 6 + (7 * 8)
    System.out.println(result3);
    
    
    //후위 연산자의 우선 순위: *, /, () 보다 우선한다.
    f = 5;
    result3 = f++ + f++ * f++;
    System.out.println(result3);
    
    f = 5;
    result3 = f++ + (f++ * f++);
    System.out.println(result3);
    
    // 배정 연산자의 실행 순선를 다시 한번 확인!
    int x = 10;
    x = x++;
    System.out.println(x);
    
  }

}










