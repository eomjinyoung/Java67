package step14.ex5;

// 오류 발생했을 때, 그 메서드가 대충 처리하기.
public class MyArrayList2 {
 Object[] pool = new Object[100];
 int length;
 
 void add(Object obj) {
   if (length >= pool.length) { // 오류 발생. 대충 처리!
     System.out.println("더이상 공간이 없습니다.");
     return;
   }
     
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
