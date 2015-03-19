package step14.ex5;

// 데이터 목록을 개별로 관리하기 위해 클래스 변수를 인스턴스 변수로 전환한다.
// => 메서드도 인스턴스 변수에 접근할 수 있도록 인스턴스 메서드로 전환한다.
public class MyArrayList {
 Object[] pool = new Object[100];
 int length;
 
 void add(Object obj) {
   pool[length++] = obj;
 }
 
 Object remove(int index) {
   Object value = pool[index];
   length--;
   for (int i = index; i < length; i++) {
     pool[i] = pool[i + 1];
   }
   return value;
 }
 
 void insert(int index, Object value) {
   for (int i = length - 1; i >= index; i--) {
     pool[i + 1] = pool[i];
   }
   pool[index] = value;
   length++;
 }
 
 void set(int index, Object value) {
   pool[index] = value;
 }

 Object get(int index) {
   return pool[index];
 }
 
 void print() {
   for (int i = 0; i < length; i++) {
     System.out.print(pool[i] + ",");
   }
   System.out.println();
 }
}
