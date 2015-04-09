package quiz;

// 출처: codefights.com
// 한 줄에 버그가 있다. 고쳐라! 
/*
Given an integer n, find the number of trailing zeros 
in the decimal representation of n! 
(the exclamation mark means factorial).

Example

for n = 10 output should be 2

[input] integer n

a positive integer
[output] integer
*/

public class Test007 {
  static int factorialTrailingZeros(int n) {  
    int result = 0;
    for (int i = 5; i <= n; i += 5) {
      int number = i;
      while (number % 2 == 0) {
        number /= 5;
        result++;
      }
    }
    return result;
  }


  public static void main(String[] args) {
    System.out.println(factorialTrailingZeros(10));

  }

}
