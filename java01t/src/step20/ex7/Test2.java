package step20.ex7;

// 실습 목표: 크리티컬 섹션에 뮤텍스 적용하기
// => 동기화(synchronize)라 부름.
// => 동기화? 일치하게 만든다. 곧 변수의 값이 스레드 실행에 상관없이
//    일치하게 만든다. 
// => 문법
//    크리티컬 섹션(특정 블록이나 메서드)에 대해 synchronized로 묶는다. 
public class Test2 {

  static class Account {
    long balance;
    
    public Account(long balance) {
      this.balance = balance;
    }
    
    // withdraw() 메서드에 한 스레드만 진입할 수 있게 지정한다.
    // => 진입하면 해당 블록 전체를 잠근다.(locking)
    // => 블록을 나올 때 잠금을 해제한다.
    // => 잠금이 해제되면 다른 스레드가 접근할 수 있다.
    // => 크리티컬 섹션을 실행하다가 CPU를 뺏기더라도, 다른 스레드는 접근할 수 없다.
    //    불쌍하게 CPU를 갖고 있는 스레드는 멀건히 기다려야 한다.
    synchronized public int withdraw(int money) {
      long currBalance = this.balance;
      
      delayTime(); // CPU 뺏기고 싶어요!
      
      currBalance -= money;
 
      delayTime(); // CPU 뺏기고 싶어요!
      
      if (currBalance < 0) 
        return 0;
      
      delayTime(); // CPU 뺏기고 싶어요!
      
      this.balance = currBalance;
      
      delayTime(); // CPU 뺏기고 싶어요!
      
      return money;
    }
    
  }
  
  static class ATM365 extends Thread {
    Account account;
    
    public ATM365(String name, Account account) {
      super(name);
      this.account = account;
    }
    
    @Override
    public void run() {
      int sum = 0;
      int money = 0;
      for (int i = 0; i < 100; i++) {
        money = account.withdraw(10000);
        
        delayTime();
        
        if (money == 0)
          break;
        
        delayTime();
        
        sum += money;
        
        delayTime();
      }
      System.out.printf("[%s]찾은 금액: %d\n", this.getName(), sum);
    }
  }

  //스레드 안전 코드 : 여러 스레드가 동시에 호출해도 문제가 없다.
  static private void delayTime() {
    // 돈을 찾는 중간에 네트웍의 속도 지연 등과 같은 이유로 
    // 프로그램 실행 중간에 약간의 시간이 지체되는 상황을 만들자.
    double x = 234.3456677888;
    x /= 2.5670345;
  }
  
  public static void main(String[] args) {
    Account account = new Account(1000000);
    
    ATM365 강남 = new ATM365("강남", account);
    ATM365 부산 = new ATM365("부산", account);
    ATM365 광주 = new ATM365("광주", account);
    ATM365 대전 = new ATM365("대전", account);
    ATM365 강릉 = new ATM365("강릉", account);

    강남.start();
    부산.start();
    광주.start();
    대전.start();
    강릉.start();
    
  }

}



















