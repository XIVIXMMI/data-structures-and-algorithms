import java.util.Scanner;

public class FindArrayAverage {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter elements number of array: ");
    int n = sc.nextInt();
    int sum = 0;
    float average;

    // inital an array
    int[] numbers =  new int[n];

    System.out.println("Enter elements of array: ");
    for (int i = 0; i < n; i++) {
      System.out.println("Elements " + i + ": ");
      numbers[i] = sc.nextInt();
    }

    // sum of array
    for (int i = 0; i < n; i++) {
      sum += numbers[i];
    }

    average = sum / n;
    
    System.out.println(average);
  }
}
