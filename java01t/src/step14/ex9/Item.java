package step14.ex9;

// 값을 보관하는 역할
public class Item {
  protected Object value; // 값 객체의 주소 저장
  protected Item next; // 다음 아이템 객체의 주소 저장 

  @Override
  public String toString() {
    return "Item [value=" + value + "]";
  }

  public Item() {}
  
  public Item(Object value) {
    this.value = value;
  }

  public Object getValue() {
    return value;
  }

  public void setValue(Object value) {
    this.value = value;
  }

  public Item getNext() {
    return next;
  }

  public void setNext(Item next) {
    this.next = next;
  }
  
  
}
