import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        HashMap<Character,Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for( int i = 0; i < s.length(); i++) {

            if( s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') 
                stack.push(s.charAt(i));

            if( s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']') {
                if (stack.peek() == null ) return false;
                if (!stack.pop().equals(map.get(s.charAt(i)))) return false;
            }
        }

        return stack.peek() == null ? true : false;
    }
}