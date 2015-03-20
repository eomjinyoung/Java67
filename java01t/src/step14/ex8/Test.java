package step14.ex8;

// LinkedList 알고리즘 구현하기
// 왜 배열을 사용하지 않고 링크드리스트라는 알고리즘을 사용하는가?
// => 배열은 한 번 크기를 정하면 바꿀 수 없다.
// => LinkedList는 저장소의 크기를 바꿀 수 있다.
// 원리
// => 열차의 객차를 추가하거나 제거하는 방법 
public class Test {

  public static void main(String[] args) {
    MyLinkedList ll = new MyLinkedList();
    ll.add("홍길동");
    ll.add(100);
    ll.add(90);
    ll.add(80);
    ll.add("임꺽정");
    ll.add(80);
    ll.add(90);
    ll.add(100);
    
    System.out.printf("%s, %d, %d, %d\n", 
        ll.get(0), ll.get(1), ll.get(2), ll.get(3));
    System.out.printf("%s, %d, %d, %d\n", 
        ll.get(4), ll.get(5), ll.get(6), ll.get(7));
    
    // 배열 vs LinkedList
    // - 값 입력: LinkedList는 무한으로 값을 넣을 수 있다. 메모리를 효율적으로 관리.
    // - 조회: 배열이 훨씬 빠르다. LinkedList는 매번 조회할 때마다 처음부터 뒤져야 한다.
    // - 삽입: 배열에서 값을 삽입하려면 뒤로 값을 미뤄야 한다. LinkedList는 빠르다.
    // - 삭제: 배열에서 값을 삭제하려면 앞으로 땡겨야 한다. LinkedList는 빠르다. 
    // - 변경: 배열은 바로 찾아서 변경. 
    //        LinkedList는 해당 인덱스를 처음부터 따라가서 찾아야 하기 때문에 느리다.
  }

}








