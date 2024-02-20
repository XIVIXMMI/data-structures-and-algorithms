package Recursion;

import java.util.Scanner;

public class TowerOfHanoi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of disk: ");
        int n = scanner.nextInt();
        MoveDisk(n,"A","B","C");
    }
    public static void MoveDisk(int n, String source, String auxiliary, String destination){
        if(n == 1){
            System.out.println("\t" + source + "----->" + destination);
            return;
        }
        MoveDisk(n-1,source,auxiliary,destination);
        MoveDisk(1,source,auxiliary,destination);
        MoveDisk(n-1,source,auxiliary,destination);
    }
}
