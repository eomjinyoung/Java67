package step16.ch08;

/* testCar()에서 호출하는 메서드를 규칙으로 정의한다.
 * => 이 규칙을 공개하여, 앞으로 차를 만드는 모든 회사에서는
 *    이 규칙에 따라 자동차를 만들어야 한다.
 */
public interface ICar {
  String getModel();
  void dashboard();
  void accelerate();
  void reduce();
  void stop();
}
