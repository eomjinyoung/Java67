
public class StudentSelector {

  public static void main(String[] args) throws Exception {
    String[] students = {
        "김찬기",
        "이혜인",
        
        "정병근","이서준"};
    /*
    String[] students = {"배광한","심기백","고유식","안병래","황명헌",
        "심훈","남경훈","원석환","김찬기","박재민",
        "김규현","김희인","이혜인","박정민",
        "장인순","우인규","김범준","정준호","김일권",
        "정병근","이서준"};
    */
    int no = 0; 
    
    for (int i = 0; i < 10; i++) {
      no = (int)(Math.random() * 4);
      //System.out.print(".");
      System.out.println(students[no]);
      Thread.sleep(200);
    }
    Thread.sleep(5000);
    System.out.println(students[no]);

  }

}
