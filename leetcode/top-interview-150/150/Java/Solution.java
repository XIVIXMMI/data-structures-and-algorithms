import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public static int evalRPN(String[] tokens) {
        Deque<Integer> nums = new ArrayDeque<>();
        int result = Integer.parseInt(tokens[0]);

        for (String token : tokens) {
            int num1;
            int num2;
            switch (token) {
                case "+":
                    num1 = nums.pop();
                    num2 = nums.pop();
                    result = num1 + num2;
                    nums.push(result);
                    break;
                case "-":
                    num1 = nums.pop();
                    num2 = nums.pop();
                    result = num2 - num1;
                    nums.push(result);
                    break;
                case "*":
                    num1 = nums.pop();
                    num2 = nums.pop();
                    result = num1 * num2;
                    nums.push(result);
                    break;
                case "/":
                    num1 = nums.pop();
                    num2 = nums.pop();
                    result = num2 / num1;
                    nums.push(result);
                    break;

                default:
                    int num = Integer.parseInt(token);
                    nums.push(num);
                    break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
    // Test 1: (2 + 1) * 3 = 9
    String[] tokens1 = {"2", "1", "+", "3", "*"};
    System.out.println(evalRPN(tokens1)); // expect 9

    // Test 2: 4 + (13 / 5) = 6
    String[] tokens2 = {"4", "13", "5", "/", "+"};
    System.out.println(evalRPN(tokens2)); // expect 6

    // Test 3: negative number
    String[] tokens3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
    System.out.println(evalRPN(tokens3)); // expect 22
}
}