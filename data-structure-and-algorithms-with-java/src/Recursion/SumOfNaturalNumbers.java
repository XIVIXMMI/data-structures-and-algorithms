package Recursion;

public class SumOfNaturalNumbers {
    public static void main(String[] args) {
        System.out.println(recursiveSummation(5));
    }
    public static int recursiveSummation(int input){
        if(input <= 1)
            return input;
        return input + recursiveSummation(input -1);
    }
}
