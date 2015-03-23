package step14.ex9;

public class MyStack {
  Item cursor;
  int length;
  
  public void push(Object value) {
    Item newItem = new Item();
    newItem.value = value;
    newItem.next = cursor;
    cursor = newItem;
    length++;
  }
  
  public Object pop() {
    if (cursor == null) {
      return null;
    }
    
    Object value = cursor.value;
    cursor = cursor.next;
    length--;
    return value;
  }

  public int size() {
    return length;
  }
}
