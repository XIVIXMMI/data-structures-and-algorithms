import java.util.HashMap;
import java.util.Map;

/**
 * MAJORITY ELEMENT
 * Given an array nums of size n, return the majority element
 * The majority element is the element that appears more than ⌊n / 2⌋ times
 * You may assume that the majority element always exists in the array
 *
 *
 * Could use Boyer-Moore Majority Vote to sold this problem
 *
 * Use 2 variable:
 * candidate : can be majority
 * count : count the vote ( or the appearences) of the candidate
 *
 * Loop through the `nums`
 * if count == 0, then choose the current element can be the candidate
 * if next element == candidates, then increase the count
 * ortherwise, decrease the count !
 *
 */

 public class Solution_1 {
     public int majorityElement(int[] nums){
         HashMap<Integer,Integer> map =  new HashMap<>();
         for( int n : nums){
             int value = map.getOrDefault(n, 0);
             value = value + 1;
             map.put(n, value);
         }
         
         int threshold = nums.length / 2;
         for(Map.Entry<Integer, Integer> entry : map.entrySet()){
             int value = entry.getValue();
             int key = entry.getKey();
             if( value > threshold ){
                 return key;
             }
         }
         
         return 0;
     }
 }
 