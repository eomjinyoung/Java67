package step14.ex5;

// 예외 처리 문법 적용
// - 오류가 발생하는 부분에 다음 코드를 넣는다.
//   throw new Throwable("오류 정보")
// - 예외 정보를 던지는 메서드 선언부에 다음 코드를 넣는다.
//   public void m() throws Throwable {
// - Throwable 클래스: 오류 정보를 표현하는 클래스이다.
public class MyArrayList4 {
  Object[] pool = new Object[100];
  int length;

  // - 오류 상황을 알리기 위해 더이상 리턴 값을 사용할 필요가 없다.
  // - 오류 내용은 Throwable 객체에 담는다.
  // - 호출자에게 알리는 방법은 throw 명령을 사용하여 Throwable 객체를 던지는 것이다.
  // - 오류 정보를 던지는 메서드는 어떤 오류를 던지는지 선언해야 한다.
  // - 강조! throw는 오직 Throwable 객체만 던질 수 있다.
  void add(Object obj) throws Throwable {
    if (length >= pool.length) { // 오류 발생. 대충 처리!
      throw new Throwable("오류 정보");
    }

    pool[length++] = obj;
  }

  Object remove(int index) throws Throwable {
    // throw 라는 명령을 보는 즉시, 오류에 대한 처리라는 것을 직관적으로 알 수 있다.
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
