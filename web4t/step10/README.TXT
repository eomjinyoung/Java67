[10단계: 개발자가 직접 코드를 통해 트랜잭션을 관리]
- 트랜잭션으로 처리할 작업은 개발자가 직접 코드를 통해 제어한다.
* 트랜잭션
- 여러 개의 데이터 변경 작업(data manipulation; inset, update, delete)을
  하나의 단위, 하나의 그룹으로 묶는 것.

* 트랜잭션 정책(propagation)
                      호출자(tx1)        호출자(트랜잭션에 소속되지 않음)
1) REQUIRED             tx1             new(tx1)
2) REQUIRES_NEW         new(tx2)        new(tx1)
3) SUPPORTS             tx1             트랜잭션 없이 실행
4) NOT_SUPPORTED        트랜잭션 없이 실행  트랜잭션 없이 실행
5) MANDATORY            tx1             예외 발생!
6) NEVER                예외 발생!        트랜잭션 없이 실행 

예) 
메서드1() {     tx1
  insert      
  insert
  메서드2() 호출   
      insert    
      update    
      delete    
  update
  update
} 
      
1. BoardService 클래스의 insert(), change(), remove() 메서드 변경






















