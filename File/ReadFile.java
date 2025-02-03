import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
  public static void main(String[] args) {
    try {
      File file = new File("test.txt");
      Scanner sc = new Scanner(file);
      if(file.exists()){
        System.out.println("File Name: "+file.getName());
        System.out.println("Path: "+file.getAbsolutePath());
        System.out.println("Writeable: "+file.canWrite());
        System.out.println("Readable: "+file.canRead());
        System.out.println("Size in bytes: "+file.length());
      }
      while (sc.hasNextLine()) {
        String data = sc.nextLine();
        System.out.println("Content: "+data);
      }
    } catch (Exception e) {
      System.out.println("An Error Occured.");
      e.printStackTrace();
    }
  }
}
