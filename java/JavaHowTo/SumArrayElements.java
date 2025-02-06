import java.util.Scanner;

public class SumArrayElements {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter size of Array: ");
    int n = sc.nextInt();
    int[] numbers = new int[n];
    
    // enter array elements form keyboard
    System.out.println("Enter elements of array: ");
    for(int i = 0; i < n; i++){
      System.out.println("elements " + i + ": ");
      numbers[i] = sc.nextInt(); 
    }

    // print array
    System.out.println("Elements of Array: ");
    for(int i = 0; i < n; i++){
      System.out.println(numbers[i] + " ");
    }

    // sum array
    int sum = 0;
    for(int i = 0; i < n; i++){
      sum += numbers[i];
    }

    System.out.println("Sum elements of Array: "+sum);
  }
}
