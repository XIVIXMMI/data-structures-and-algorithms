import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

class Solution {
    public boolean isValid(String s) {
        // use a stack to make sure the order is correct
        Deque<Character> stack = new ArrayDeque<>();
        // using hashmap to store the corresponding pairs of characters
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');

        // loop through the string
        for( int i = 0; i < s.length(); i++) {
            // if the character is one of '( { [' 
            // -> then push them to stack
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') 
                stack.push(s.charAt(i));
            // if the character is one of ') } ]' 
            // -> find the value in the maeep then return false if it doesn't equal otherwise pop the top of the stack out
            if(s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']') {
                if(stack.peek() == null ) return false;
                if(!stack.pop().equals(map.get(s.charAt(i)))) return false;
            }
        }

        // after loop throught the string, if the stack still contains characters then return false otherwise return true
        return stack.peek() == null ? true : false;
    }
}