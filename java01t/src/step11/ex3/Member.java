package step11.ex3;

// equals()를 오버라이딩 
// - 같은 값을 가질 때 true를 리턴하게 만든다.
public class Member {
  String name;
  String id;
  String password;
  
  @Override
  public boolean equals(Object obj) {
    //1) 파라미터로 넘어오는 값이 정말 Member 객체인지 조사한다.
    if (!(obj instanceof Member))
      return false;
    
    Member other = (Member) obj;
    
    if (!(this.name == other.name)) 
      return false;
    
    if (!(this.id == other.id)) 
      return false;
    
    if (!(this.password == other.password))
      return false;
    
    return true;
  }
}
