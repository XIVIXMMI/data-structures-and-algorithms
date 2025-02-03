import java.io.FileWriter;
import java.io.IOException;

public class Main {
  public static void main(String[] args) {
    try {
      FileWriter obj = new FileWriter("test.txt");
/*      if ( obj.createNewFile()) {
      System.out.println("File created "+obj.getName());
      } else {
        System.out.println("File already existed");
      }
      */
      obj.write("Hello world, i'm learning how to work with File using Java, it's fun :D");
      obj.close();
      System.out.println("File has been wrote successfully.");
    } catch (IOException e) {
      System.out.println("An error occured.");
      e.printStackTrace();
    }
  }
}
