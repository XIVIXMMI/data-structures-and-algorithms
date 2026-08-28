import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] rs = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();
                rs[idx] = i - idx;
            }
            stack.push(i);
        }
        return rs;
    }
}

/*

rs[index_pop] = i - index_pop

i = 0 (73) -> stack rỗng -> push(0) -> stack[0] ->  rs[0,0,0,0,0,0,0,0]
i = 1 (74) -> 73 < 74 -> pop(0), push(1) -> stack[1] -> rs[0] = 1 - 0 = 1; rs[1,0,0,0,0,0,0,0]
i = 2 (75) -> 74 < 75 -> pop(1), push(2) -> stack[2] -> rs[1] = 2 - 1 = 1; rs[1,1,0,0,0,0,0,0]
i = 3 (71) -> 75 > 71 -> push(3) -> stack[2,3] [] -> rs[1,1,0,0,0,0,0,0]
i = 4 (69) -> 71 > 69 -> push(4) -> stack[2,3,4] -> rs[1,1,0,0,0,0,0,0]
i = 5 (72) -> 69 < 72; 71 < 72 -> pop(4), pop(3), push(5) -> stack[2,5] -> rs[4] = 5 - 4 = 1; rs[3] 5 - 3 = 2; rs[1,1,0,2,1,0,0,0]
i = 6 (76) -> 76 > 72; 76 > 75 -> pop(5), pop(2), push(6) -> stack[6] -> rs[5] = 6 - 5 = 1; rs[2] = 6 - 2 = 4; rs[1,1,4,2,1,1,0,0]
i = 7 (73) -> 73 < 76 -> push(7) -> stack[6,7] -> rs[1,1,4,2,1,1,0,0]
*/