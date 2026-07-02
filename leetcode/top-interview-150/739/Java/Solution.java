import java.util.Stack;

class Solution {
    // Time Complexity = O(n) ~ 61ms
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 1; i < n; i++) {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int idx = stack.pop();
                answer[idx] = i - idx;
            }
            stack.push(i);
        }

        return answer;
    }

    // Time Complexity = O(n) ~ 6ms
    public int[] dailyTemperatures_Array(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        int[] stack = new int[n];
        int top = -1; // stack is empty

        for (int i = 1; i < n; i++) {
            while(top != -1 && temperatures[i] > temperatures[stack[top]]){
                int idx = stack[top--]; // pop stack
                answer[idx] = i - idx;
            }
            stack[++top] = i;
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