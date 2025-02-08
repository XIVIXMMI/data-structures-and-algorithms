import java.util.Scanner;

public class FindSmallestElement {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("enter numbers element of array: ");
    int n = sc.nextInt();

    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      System.out.println("enter element " + i + " value ");
      arr[i] = sc.nextInt();
    }

    int smallestElement = arr[0];

    for (int i = 0; i < n; i++) {
      if(smallestElement > arr[i]){
        smallestElement = arr[i];
      }
    }

    System.out.println("Smallest Element in array is " + smallestElement);
  }
}
