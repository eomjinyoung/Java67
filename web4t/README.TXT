[6단계: mybatis의 MapperScannerConfigurer 사용하기]
- 개발자는 DAO가 갖춰야할 메서드를 인터페이스로 정의한다.
- DAO의 구현은 mybatis가 맡는다.

1. 의존 라이브러리 추가
- spring-mybatis 라이브러리 추가. (이미 추가되어 있음)

2. 인터페이스 정의
- 네임스페이스 이름은 인터페이스 이름과 같게 한다.
1) 메서드의 이름은 SQL ID와 같아야 한다.
2) 메서드의 파라미터는 SQL에 정의된 파라미터 타입과 같아야 한다.
3) 메서드의 파라미터는 오직 한 개만 가능한다.

3. 인터페이스 변경에 맞추어 페이지 컨트롤러를 수정한다.
- BoardController, AuthController

4. 스프링 설정 파일에 MapperScannerConfigurer 객체를 등록한다.
- DAO는 모든 프론트 컨트롤러가 공유하기 때문에,
  ContextLoaderListener에서 설정하라!
  => application-context.xml 설정 파일에 다음 객체를 추가하라!
  
<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
  <property name="basePackage" value="net.bitacademy.java67.dao" />
</bean>  
  
  
  
  
  
  
  
  