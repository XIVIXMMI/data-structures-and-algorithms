from typing import List


class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        i = 0
        j = len(nums) - 1

        while i <= j:
            if nums[i] !=  val:
                i += 1
            else:
                temp = nums[i]
                nums[i] = nums[j]
                nums[j] = temp
                j -= 1

        return i
    
if __name__ == "__main__":
    nums = [0,1,2,2,3,0,4,2]
    val = 2
    sol = Solution()
    print(sol.removeElement(nums,2))

