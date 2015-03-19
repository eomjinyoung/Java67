package step14.ex5;

// 오류 발생했을 때, 리턴 값을 통해 호출자에게 오류의 상황을 알린다.
public class MyArrayList3 {
  Object[] pool = new Object[100];
  int length;

  //배열의 크기를 초과하여 입력하면, -1을 리턴한다. => 호출자에게 오류 상황을 알린다.
  int add(Object obj) {
    if (length >= pool.length) { // 오류 발생. 대충 처리!
      return -1;
    }

    pool[length++] = obj;
    return 0;
  }

  // 인덱스 범위를 벗어나는 경우와 값이 존재하지 않는 경우를 나눠서 오류를 호출자에게 알리고 싶다!
  // - 다양한 종류의 리턴을 통해 알린다. => 호출자는 리턴 값을 복잡한 방식으로 검사해야 한다. 
  Object remove(int index) {
    // 인덱스 범위를 벗어나는 경우
    if (index >= pool.length) {
      return -1; // 오류의 특별 코드를 리턴한다.
    }
    
    // 존재하지 않는 값을 지우려는 경우,
    if (index >= length) {
      return null;
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
