// Definition for a binary tree node.
#[derive(Debug, PartialEq, Eq)]
pub struct TreeNode {
    pub val: i32,
    pub left: Option<Rc<RefCell<TreeNode>>>,
    pub right: Option<Rc<RefCell<TreeNode>>>,
}

impl TreeNode {
    #[inline]
    pub fn new(val: i32) -> Self {
        TreeNode {
            val,
            left: None,
            right: None,
        }
    }
}

use std::cell::RefCell;
use std::rc::Rc;
impl Solution {
    pub fn sorted_array_to_bst(nums: Vec<i32>) -> Option<Rc<RefCell<TreeNode>>> {
        let left: i32 = 0;
        let right: i32 = nums.len() as i32 - 1;

        Self::solve(&nums, left, right)
    }

    fn solve(nums: &[i32], left: i32, right: i32) -> Option<Rc<RefCell<TreeNode>>> {
        if left > right {
            return None;
        }

        let mid = ((left + right) / 2) as usize;

        Some(Rc::new(RefCell::new(TreeNode {
            val: nums[mid],
            left: Self::solve(nums, left, mid as i32 - 1),
            right: Self::solve(nums, mid as i32 + 1, right)
        }))
    }
}
