package step14.ex8;

// LinkedList 알고리즘에 따라 데이터 보관을 수행한다.
// => 데이터를 무한으로 넣을 수 있다.
// => 단 특정 인덱스에 있는 값을 꺼낼 때 속도가 느리다.
//    => 찾아가야 하기 때문에.
public class MyLinkedList {
  Item start; // 시작 Item 객체를 가리킬 참조 변수
  Item end; // 마지막 Item 객체를 가리킬 참조 변수. 항상 마지막은 빈 객체이다.
  int length; // 보관소에 저장된 Item의 개수 

  public MyLinkedList() {
    start = new Item();
    end = start;
  }

  public void add(Object value) {
    end.value = value;
    end.next = new Item();
    end = end.next;
    length++; // Item 추가하면 보관소의 크기를 한 개 증가시킨다.
  }

  public int size() {
    return length;
  }

  public Object get(int index) {
    if (index >= length || index < 0) {
      throw new InvalidIndexException("인덱스가 저장소의 범위 밖을 가리킵니다.");
    } 
      
    Item cursor = start; // LinkedList를 따라 갈 때 현재 Item을 가리키는 변수
    int count = 0;

    while (count < index) {
      cursor = cursor.next;
      count++;
    }

    return cursor.value;
  }

  // InvalidIndexException은 RuntimeException 계열이기 때문에,
  // 메서드 선언부에 어떤 예외를 던지는지 선언할 필요가 없다.
  public void insert(int index, Object value) {
    if (index == length) {
      add(value);
      return;
    }
    
    if (index > length || index < 0) {
      throw new InvalidIndexException("인덱스가 저장소의 범위 밖을 가리킵니다.");
    }
      
    Item newItem = new Item();
    newItem.value = value;

    length++;

    Item cursor = start;

    if (index == 0){
      newItem.next = start;
      start = newItem;
      return;
    }

    int i = 0;
    while (i < index - 1) {
      cursor = cursor.next;
      i++;
    }

    newItem.next = cursor.next;
    cursor.next = newItem;
  }

  public Object remove(int index) {
    if (index >= length || index < 0) {
      throw new InvalidIndexException("인덱스가 저장소의 범위 밖을 가리킵니다.");
    }
    
    Item cursor = start;
    length--;
    Item temp = null;

    if (index == 0) {
      temp = start;
      start = start.next;
      return temp;

    }

    int i = 0;
    while (i < index - 1) {
      cursor = cursor.next;
      i++;
    }

    temp = cursor.next;
    cursor.next = cursor.next.next;
    return temp;
  }

  public void set(int index, Object value) {
    if (index >= length || index < 0) {
      throw new InvalidIndexException("인덱스가 저장소의 범위 밖을 가리킵니다.");
    }
    
    int i = 0;
    Item cursor = start;

    while (i < index) {
      cursor = cursor.next;
      i++;
    }
    cursor.setValue(value);
  }
}












