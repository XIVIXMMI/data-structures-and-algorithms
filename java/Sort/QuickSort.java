import java.util.Random;

public class QuickSort {
  public static void main(String[] args) {
    Random rand = new Random();

    int[] numbers = new int[10];

    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = rand.nextInt(20);
    }
    for (int i : numbers) {
      System.out.println("Before: " + i);
    }

    quickSort(numbers, 0, numbers.length - 1);
    for (int i : numbers) {
      System.out.println("After: " + i);
    }
  }

  private static void quickSort(int[] arr, int low, int high) {
    if (low < high) {
      int partitionIndex = partition(arr, low, high);

      quickSort(arr, low, partitionIndex - 1);
      quickSort(arr, partitionIndex + 1, high);
    }

  }

  private static int partition(int[] arr, int low, int high) {
    int pivot = arr[high];
    int i = low - 1;

    for (int j = low; j < high; j++) {
      if (arr[j] < pivot) {
        i++;
        swap(arr, i, j);
      }
      swap(arr, i + 1, high);
    }
    return i + 1;
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

}
