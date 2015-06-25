[11단계: 애노테이션을 통해 트랜잭션을 관리]
- @Transactional 애노테이션을 사용하라!
- 스프링 설정 파일에 @Transactional 애노테이션을 처리할 객체를 등록하라.
  <tx:annotation-driven transaction-manager="txManager"/>
  
      
1. BoardService 클래스의 insert(), change(), remove() 메서드 변경






















