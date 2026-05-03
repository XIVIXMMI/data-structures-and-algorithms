import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        System.err.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> consecutives = new HashSet<>(); // lookup O(1)
        for (int num : nums) {
            consecutives.add(num);
        }
        int max = 0;
        for (Integer num : consecutives) {
            if( !consecutives.contains(num - 1)){
                int currentNum = num;
                int length = 1;
                while( consecutives.contains(currentNum + 1)){
                    currentNum++;
                    length++;
                }
                max = Math.max(max, length);
            } 
        }
        return max;
    }
}
