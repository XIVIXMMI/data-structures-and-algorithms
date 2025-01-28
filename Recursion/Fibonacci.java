package Recursion;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("enter a number: ");
        long n = scanner.nextLong();

        for( long i = 0; i <=n; i++){
            System.out.println(FibRecursive(i));
        }
    }

    public static long FibRecursive(long n){
        if((n == 0 || n == 1))
            return n;
        else{
            return FibRecursive(n -1) + FibRecursive(n -2);
        }
    }

    public static void FibLoop(long n){
        long f, f1 = 1, f2 =1;
        System.out.println("Fibonacci of "+n);
        if(n <= 2){
            System.out.println("n must be bigger than 2");
        }else {
            for(int i = 3; i <= n; i++){
                f = f1 + f2;
                System.out.println(f);
                f1 = f2;
                f2 = f;
            }
        }
    }
}
