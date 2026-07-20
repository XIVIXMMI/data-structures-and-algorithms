import java.util.HashSet;

public class Solution2 {
    public static int longestConsecutive(int[] nums) {
        int currentNum = 0;
        int maxLength = 0;

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        for (int num : set) {
            if (!set.contains(num - 1)) {
                currentNum = num;
                int length = 1;
                while (set.contains(currentNum + 1)) {
                    length += 1;
                    currentNum = currentNum + 1;
                }
                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = { 9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6 };
        System.out.println(longestConsecutive(nums));
    }
}
