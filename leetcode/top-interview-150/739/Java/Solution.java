import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();

        while (n > 0) {
            
        }


        return answer;
    }

    // Time Complexity = O(n^2)
    public int[] dailyTemperatures_BruteForce(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[temperatures.length];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (temperatures[i] < temperatures[j]) {
                    answer[i] = j - i;
                    break;
                }
            }
        }
        return answer;
    }

}