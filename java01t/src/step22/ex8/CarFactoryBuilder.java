package step22.ex8;

/* 실습 목표: Builder 객체 만들기 (Builder Pattern)
 * - 여러 부품들을 조립하여 객체를 만들어야 하는 경우, 
 *   객체 생성 과정의 복잡함을 감추기 위해 사용하는 설계 기법.  
 */
public class CarFactoryBuilder {
  public static CarFactory build(String carModel) {
    switch (carModel) {
    case "tico":
      return new TicoFactory();
    default:
      return new TruckFactory();
    }
  }
}
