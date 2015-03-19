package step14.ex1;

// 배열을 이용하여 여러 인스턴스의 주소를 관리하기

public class Test {
  // 인스턴스 주소를 저장할 배열을 준비한다.
  static Object[] pool = new Object[100];

  // 배열에서 저장할 위치를 가리키는 변수
  static int length;
  
  static void add(Object obj) {
    pool[length++] = obj;
  }
  
  // 풀에 저장된 값을 제거한다. 보통 제거된 값을 리턴한다.
  static Object remove(int index) {
    Object value = pool[index];
    length--;
    for (int i = index; i < length; i++) {
      pool[i] = pool[i + 1];
    }
    return value;
  }
  
  static void insert(int index, Object value) {
    //방법: 끝에서부터 삽입하려는 방까지 다음 칸으로 값을 이동한 후, 
    //    현재 방에 값을 넣는다.
    //1) 마지막 값의 방부터 index로 지정한 방까지의 값을 한 칸 앞으로 이동한다.
    for (int i = length - 1; i >= index; i--) {
      pool[i + 1] = pool[i];
    }
    //2) index가 지정한 방에 값을 넣는다.
    pool[index] = value;
    
    //3) length를 증가시켜서 빈 방을 가리키게 한다.
    length++;
  }
  
  // 기존에 저장된 값을 변경 
  static void set(int index, Object value) {
    pool[index] = value;
  }
  
  // 풀에 저장된 값을 꺼내기
  static Object get(int index) {
    return pool[index];
  }
  
  static void print() {
    for (int i = 0; i < length; i++) {
      System.out.print(pool[i] + ",");
    }
    System.out.println();
  }
  
  public static void main(String[] args) {
    add("홍길동"); //0
    add("임꺽정"); //1
    add("유관순"); //2
    add("윤봉길"); //3
    add("안중근"); //4
    add("안창호"); //5
    
    insert(2, "윤동주");
    print();
    
    set(3, "이육사");
    set(4, "김소월");
    print();
    
    System.out.println(get(3));
    System.out.println(get(4));
    
    System.out.println(remove(3));
    System.out.println(remove(3));
    print();

  }

}









