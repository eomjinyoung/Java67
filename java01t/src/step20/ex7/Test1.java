package step20.ex7;

// 실습 목표: 다중 스레드에 안전하지 않는 코드
// => 여러 스레드에서 동시에 withdraw()를 호출한다.
// => 여러 스레드가 동시에 balance 변수 값을 변경한다.
// => 잘못된 결과를 만든다.
// 
// withdraw()처럼 동시에 여러 스레드가 호출했을 때 문제가 발생되는 것을
// "스레드에 안전하지 않는 코드"라고 부른다.
// => Critical Section(Region)(임계 구역) 이라고 한다.
//    => 동시에 여러 스레드가 접근했을 때 잘못된 결과를 낼 수 있는 코드 블록.
//
// 해결책? 접근 개수의 관리가 필요하다.
// 
// 1) 세마포어(Semaphore)
// => 크리티컬 섹션에 접근할 수 있는 스레드의 수를 지정한다.
// => 지정되 개수를 초과하면 다른 스레드는 기다려야 한다.
// => 화장실!
//
// 2) 뮤텍스(Mutex: Mutual Exclusion, 상호 배제)
// => 1개짜리 세마포어를 말한다.
//
// Thread-Safe
// => 동시에 여러 스레드가 접근하더라도 실행 결과에 문제가 없는 코드 
// => 예) delayTime()
public class Test1 {

  static class Account {
    long balance;
    
    public Account(long balance) {
      this.balance = balance;
    }
    
    public int withdraw(int money) {
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



















