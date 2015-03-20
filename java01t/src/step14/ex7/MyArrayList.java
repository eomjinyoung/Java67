package step14.ex7;

public class MyArrayList {
  Object[] pool = new Object[100];
  int length;

  void add(Object obj) throws Throwable {
    if (length >= pool.length) { // 오류 발생. 대충 처리!
      throw new Throwable("오류 정보");
    }

    pool[length++] = obj;
  }

  Object remove(int index) throws Throwable {
    if (index >= pool.length) {
      throw new Throwable("공간을 초과하였다.");
    }
    
    if (index >= length) {
      throw new Throwable("존재하지 않는 값이다.");
    }
    
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
