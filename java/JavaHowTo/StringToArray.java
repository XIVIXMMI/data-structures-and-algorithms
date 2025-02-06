import java.util.Scanner;

public class StringToArray {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a string: ");
    String str = sc.nextLine();

    char[] strArr =  str.toCharArray();

    for(char i : strArr){
      System.out.println(i);
    }
  }
}
