public class Solution {
    
    public static void main(String[] args) {
        int[] numbers = {5, 25, 75};
        int target = 100;
        int[] result = twoSum(numbers, target);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] twoSum(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length - 1;
        int[] result = new int[2];
        
        while ( left < right){
            int addition = numbers[left] + numbers[right];
            if( addition == target){
                result[0] = left + 1;
                result[1] = right + 1;
                return result;
            } 
            if (addition <= target){
                left++;
            }
            if ( addition >= target){
                right--;
            }
        }
        return result;
    }
}
