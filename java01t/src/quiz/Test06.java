package quiz;

// 출처: codefights.com
// 한 줄에 버그가 있다. 고쳐라! 
/*
A geometric progression is a sequence of numbers 
where each term after the first is found 
by multiplying the previous one by a fixed, non-zero number.

Example

isGeometricProgression([1, 4, 16]) = true
isGeometricProgression([2, 4, 8, 17, 34]) = false
[input] array.integer sequence

array of integers
[output] boolean

true if sequence represents a geometric progression,
*/

public class Test06 {
  static boolean isGeometricProgression(int[] sequence) {

    for (int i = 2; i < sequence.length; i++) {
      if (sequence[i] * sequence[0] == sequence[i - 1] * sequence[1]) {
        return false;
      }
    }
    return true;
  }


  public static void main(String[] args) {
    System.out.println(isGeometricProgression(new int[]{1,4,16}));
    System.out.println(isGeometricProgression(new int[]{2,4,8,17,34}));

  }

}
