import java.io.File;

public class DeleteFolder {
  public static void main(String[] args) {
    File file = new File("Users/omori/dsa/dsa/java/src/File/test");
    if(file.delete()){
      System.out.println("Deleted folder "+file.getName());
    } else {
      System.out.println("Failed to delete file.");
    }
  }
}
