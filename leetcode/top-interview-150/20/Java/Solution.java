import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public static void main(String[] args) {
        
    }

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int n = 0;
        while (n < s.length()) {
            char c = s.charAt(n);
            if( c == '(' || c == '[' || c == '{'){
                stack.push(c);
            } else {
                if(stack.isEmpty()) return false;
                char top = stack.pop();
                if(c == ')' && top != '(') return false;
                if(c == ']' && top != '[') return false;
                if(c == '}' && top != '{') return false;
            }
            n++;
        }
        return stack.isEmpty();
    }
    
}
