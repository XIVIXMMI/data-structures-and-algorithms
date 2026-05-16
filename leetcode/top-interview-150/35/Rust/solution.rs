pub fn search_insert(nums: Vec<i32>, target: i32) -> i32 {
    let mut left: i32 = 0;
    let mut right: i32 = nums.len() as i32 - 1;
    while left <= right {
        let mid = left + (right - left) / 2;
        if nums[mid as usize] == target {
            return mid;
        } else if nums[mid as usize] > target {
            right = mid - 1;
        } else {
            left = mid + 1
        }
    }
    left
}

pub fn search_insert(nums: Vec<i32>, target: i32) -> i32 {
    nums.partition_point(|&x| x < target) as i32
}