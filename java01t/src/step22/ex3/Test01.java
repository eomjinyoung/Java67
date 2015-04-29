package step22.ex3;

public class Test01 {

  public static void main(String[] args) throws Exception {
    CalcSkel skel = new CalcSkel();
    
    // 클라이언트쪽 브로커가 원격 객체를 대신한다.
    System.out.println(skel.plus(30, 50));
    

  }

}
