package step14.ex5;

// 오류를 처리하는 방법
// 
// 일을 시킨 메서드에서 작업을 하다가 오류가 발생했을 때,
// 대처법1: 즉시 실행을 멈춘다.
// 대처법2: 그냥 자기가 처리하고, 계속 실행한다.
// 대처법3: 호출자에게 알린다.
//
// 실습3: 오류 발생했을 때, 호출자에게 알린다.
public class Test3 {

  public static void main(String[] args) {
    MyArrayList3 array = new MyArrayList3();
    for (int i = 0; i < 101; i++) {
      // add()에서 오류가 발생하면 리턴 값으로 알려준다. 
      // => 그러면, 개발자가 그에 대한 대응책을 아래와 같이 마련할 수 있다.
      if ( array.add("홍길동" + i) == -1) {
        System.out.println("무료 버전은 100명까지만 인명을 관리할 수 있습니다.");
        break;
      }
    }
    
    MyArrayList3 array2 = new MyArrayList3();
    array2.add("홍기동");
    array2.add("김기동");
    array2.add("박기동");
    
    Object value = array2.remove(0);
    if (value == null) 
      System.out.println("삭제할 이름이 없습니다.");
    else if (!(value instanceof String))
      System.out.println("존재하지 않는 인덱스입니다.");
    
    value = array2.remove(0);
    if (value == null) 
      System.out.println("삭제할 이름이 없습니다.");
    else if (!(value instanceof String))
      System.out.println("존재하지 않는 인덱스입니다.");
    
    value = array2.remove(0);
    if (value == null) 
      System.out.println("삭제할 이름이 없습니다.");
    else if (!(value instanceof String))
      System.out.println("존재하지 않는 인덱스입니다.");

    // 오류 예1) 배열에 저장되지 않은 값을 삭제하라고 명령을 내린다.
    // => 대응법: "더이상 삭제할 이름이 없습니다." 
    value = array2.remove(0);
    if (value == null) 
      System.out.println("삭제할 이름이 없습니다.");
    else if (!(value instanceof String))
      System.out.println("존재하지 않는 인덱스입니다.");
    
    // 오류 예2) 배열의 크기를 벗어나는 인덱스를 지정한다.
    // => 대응법: "존재하지 않는 인덱스입니다."
    value = array2.remove(200);
    if (value == null) 
      System.out.println("삭제할 이름이 없습니다.");
    else if (!(value instanceof String))
      System.out.println("존재하지 않는 인덱스입니다.");
    
    
    // 리턴 값으로 다양한 오류를 구분할 수 있어서 좋다.
    // 고민1: 실제 실행하려면 명령과 오류를 처리하는 명령어가 서로 섞여 있어서 
    //       코드를 읽기가 어렵다.
    // 고민2: 리턴 값으로 다양한 여러 오류를 전달하기에는 매우 복잡하다.
    //       => 메서드 호출 후, 오류의 상태를 조사하기에 직관적이지 않다.
    // 고민3: 단순한 예제에서는 호출자에게 보고하면 되지만,
    //       복잡한 시스템에서는 여런 단계의 호출을 거치는데, 
    //       맨 밑단에서 발생된 오류를 가장 윗단으로 전달하는 방법은?
    
    // 이런 오류 처리에 대한 고민을 해결하기 위해 등장한 문법 => 예외 처리 문법!
  }

}








