
public class FibonacciForLoop {
  public static void main(String[] args) {

    int a = 0;
    int b = 1;

    int fib;

    System.out.println(a);
    System.out.println(b);

    for (int i = 0; i < 18; i++) {
      fib = a + b;
      System.out.println(fib);
      a = b;
      b = fib;
    }
  }
}
