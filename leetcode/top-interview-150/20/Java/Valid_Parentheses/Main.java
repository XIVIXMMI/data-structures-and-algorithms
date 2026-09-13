public class Main {
    static Solution solution = new Solution();
    public static void main(String[] args) {
        String[] tests = {
            // "()",        // expect true
            // "()[]{}",    // expect true
            // "(]",        // expect false
            // "([)]",      // expect false
            // "{[]}",      // expect true
            // "(",         // expect false
            // ")",         // expect false
            // "",          // expect true
            // "(((",       // expect false
            "([])"
        };

        for (String t : tests) {
            System.out.println("s = \"" + t + "\" -> " + solution.isValid(t));
        }
    }
}
