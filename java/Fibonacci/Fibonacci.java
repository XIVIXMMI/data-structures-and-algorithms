public class Fibonacci {
  public static void main(String[] args) {
    fib(5);
  }

  public static int fib(int n) {
    if (n <= 1) {
      return n;
    } else {
      System.out.println(n);
      return fib(n - 1) + fib(n - 2);
    }
  }
}
