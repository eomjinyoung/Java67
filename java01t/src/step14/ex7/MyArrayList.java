package step14.ex7;

public class MyArrayList {
  Object[] pool = new Object[100];
  int length;

  // 예외 클래스의 이름만 보고도 이 메서드가 어떤 상황에서 예외를 던지는지 추측할 수 있다.
  // => 이것이 Exception의 자식 예외를 만드는 이유다!
  void add(Object obj) throws PoolOverflowException {
    if (length >= pool.length) { 
      throw new PoolOverflowException();
    }

    pool[length++] = obj;
  }

  Object remove(int index) throws InvalidIndexException {
    if (index >= pool.length) {
      throw new InvalidIndexException("무효한 인덱스입니다.");
    }
    
    if (index >= length) {
      throw new InvalidIndexException("해당 인덱스에 값이 존재하지 않습니다.");
    }
    
    Object value = pool[index];
    length--;
    for (int i = index; i < length; i++) {
      pool[i] = pool[i + 1];
    }
    return value;
  }

  void insert(int index, Object value) throws InvalidIndexException {
    if (index >= length || index < 0) {
      throw new InvalidIndexException("무효한 인덱스입니다.");
    }
    
    for (int i = length - 1; i >= index; i--) {
      pool[i + 1] = pool[i];
    }
    pool[index] = value;
    length++;
  }

  void set(int index, Object value) throws InvalidIndexException {
    if (index >= length || index < 0) {
      throw new InvalidIndexException("무효한 인덱스입니다.");
    }
    pool[index] = value;
  }

  Object get(int index) throws InvalidIndexException {
    if (index >= length || index < 0) {
      throw new InvalidIndexException("무효한 인덱스입니다.");
    }
    
    return pool[index];
  }

  void print() {
    for (int i = 0; i < length; i++) {
      System.out.print(pool[i] + ",");
    }
    System.out.println();
  }
}








