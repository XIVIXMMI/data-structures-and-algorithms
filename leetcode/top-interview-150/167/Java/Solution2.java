public class Solution2 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum > target) {
                right--;
            } else {
                left++;
            }
            if (sum == target)
                return new int[] { left, right + 1 };
        }
        return new int[] { left, right + 1 };
    }
}
