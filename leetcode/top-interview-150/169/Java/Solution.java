import java.util.HashMap;
import java.util.Map;

import com.apple.laf.resources.aqua;

public class Solution {

    public static void main(String[] args) {

    }

    public static int majorityElement(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int n = nums.length;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > n/2){
                return entry.getKey();
            }
        }

        return 0;
    }

    public static int theBoyerMooreVoting ( int[] nums){
        int candidate = 0;
        int n = nums.length;
        int count = 0;
        for(int i = 0; i < n; i++){
            if( count = 0){
                candidate = i;
            }
            if( nums[i] = nums[candidate]){
                count++;
            } else {
                count--;
            }
        }
        return nums[candidate];
    }

}
