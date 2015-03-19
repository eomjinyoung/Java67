package step14.ex3;

// 배열을 사용하여 여러 값을 보관한다.
// ex1.Test에서 값 저장과 관련된 메서드를 이 클래스로 가져온다.
public class MyArrayList {
 static Object[] pool = new Object[100];
 static int length;
 
 static void add(Object obj) {
   pool[length++] = obj;
 }
 
 static Object remove(int index) {
   Object value = pool[index];
   length--;
   for (int i = index; i < length; i++) {
     pool[i] = pool[i + 1];
   }
   return value;
 }
 
 static void insert(int index, Object value) {
   for (int i = length - 1; i >= index; i--) {
     pool[i + 1] = pool[i];
   }
   pool[index] = value;
   length++;
 }
 
 static void set(int index, Object value) {
   pool[index] = value;
 }

 static Object get(int index) {
   return pool[index];
 }
 
 static void print() {
   for (int i = 0; i < length; i++) {
     System.out.print(pool[i] + ",");
   }
   System.out.println();
 }
}
