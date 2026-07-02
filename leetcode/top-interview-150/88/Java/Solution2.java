
class Solution2 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n;
        int i = m - 1;
        int j = n - 1;

        while (k >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                // non-descreasing order
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
    }
}

// nums1 = [1,2,3,0,0,0]
// nums2 = [2,5,6]
