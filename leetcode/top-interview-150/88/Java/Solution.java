public class Solution {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n - 1; // length of the final array
        int i = m - 1;
        int j = n - 1;

        while ( j >= 0){
            if (i > 0 && nums1[i] > nums2[j]){
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        merge(nums1,m,nums2,n);
        for (int i : nums1) {
            System.out.println(nums1[i]);
        }
    }
    
}
