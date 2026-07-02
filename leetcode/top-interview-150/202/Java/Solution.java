import java.util.HashSet;

class Solution {

    public static void main(String[] args) {
        int n = 19;
        System.out.println(isHappy(n));
    }

    public static boolean isHappy(int n) {
        HashSet<Integer> visted = new HashSet<>();
        while (n != 1) {
            if (visted.contains(n)) {
                return false;
            }
            visted.add(n);
            n = next(n);
        }
        return true;
    }

    public static int next(int n) {
        int sum = 0;
        while( n > 0){
            int digit = n % 10;
            sum += digit*digit;
            n = n / 10;
        }
        return sum;
    }
}
