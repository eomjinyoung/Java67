package step14.exa;

// 큐 알고리즘
// First-In First-Out
// - 첫 번째 추가된 값이 첫 번째로 나온다.
public class MyQueue {
  Item start;
  Item end;
  int length;
  
  
  public MyQueue() {
    start = new Item();
    end = start;
  }
  
  // 맨 마지막에 추가한다.
  public void put(Object value) {
    end.value = value;
    end.next = new Item();
    end = end.next;
    length++;   
  }
  
  //무조건 첫 번째 값을 꺼낸다.  
  public Object get() {
    if (start.next == null)
      return null;
      
    Object value = start.value;
    start = start.next;
    length--;
    return value;
  }
  
  public int size() {
    return length;
  }
}
