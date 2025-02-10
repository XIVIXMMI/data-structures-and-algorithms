
public class FibonacciRecursion {
  public static void main(String[] args) {
    fibonacci(0, 1, 2);
  }

  private static int fibonacci(int a, int b, int count) {
    int fib = 0;
    if (count <= 19) {
      fib = a + b;
      System.out.println(fib);
      a = b;
      b = fib;
    } else {
      return fib;
    }
    count += 1;
    return fibonacci(a, b, count);
  }
}
