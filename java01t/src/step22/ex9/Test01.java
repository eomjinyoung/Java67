package step22.ex9;

public class Test01 {

  public static void main(String[] args) {
    char c1 = 'A';
    char c2 = 'Z';
    char c3 = 'a';
    char c4 = 'z';
    char c5 = 'A' + 0x20;
    System.out.printf("%x %x %x %x %c\n", 
        (int)c1, (int)c2, (int)c3, (int)c4, c5);

  }

}
