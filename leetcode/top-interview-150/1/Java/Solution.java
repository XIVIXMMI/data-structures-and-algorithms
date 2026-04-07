import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {
        int target = 6;
        int[] nums = {3,2,4};
        // twoSumBruteForce(nums, target);
        twoSumOptimized(nums, target);
    }
    
    public static int[] twoSumBruteForce(int[] nums, int target) {
        int[] result = new int[2];
        for( int i = 0; i < nums.length; i++) {
            for ( int j = i + 1; j < nums.length; j++){
                if ( nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    public static int[] twoSumOptimized(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++){
            int x = target - nums[i];
            if ( map.containsKey(x)){
                result[0] = i;
                result[1] = map.get(x);
                return result;
            } else {
                map.put(nums[i], i);
            }
        }

        return result;
    }
}
