package step04;

import org.springframework.beans.factory.FactoryBean;

/* 스프링에서 제공하는 규칙에 따라 팩토리 역할을 수행하는 클래스를 만든다.
 * - org.springframework.beans.factory.FactoryBean 인터페이스를 구현한다.
 */
public class CarFactory3 implements FactoryBean<Car> {
  String    model;
  boolean   singleton;
  
  public void setModel(String model) {
    this.model = model;
  }
  
  public void setSingleton(boolean singleton) {
    this.singleton = singleton;
  }
  
  @Override
  public Car getObject() throws Exception {
    Car c = new Car();
    switch (model) {
    case "c1":
      c.setModel("티코");
      c.setCapacity(5);
      break;
    case "c2":
      c.setModel("아반테");
      c.setCapacity(5);
      break;
    default:
      c.setModel("소나타");
      c.setCapacity(5);
    }
    return c;
  }

  @Override
  public Class<?> getObjectType() {
    return Car.class;
  }

  @Override
  public boolean isSingleton() {
    return this.singleton;
  }
}











