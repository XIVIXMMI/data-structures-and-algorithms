//Definition for a binary tree node.
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

struct Solution;

impl Solution {
    pub fn is_valid_bst(root: Option<Rc<RefCell<TreeNode>>>) -> bool {
        let min = i64::MIN;
        let max = i64::MAX;
        Self::validate(root, min, max)
    }

    fn validate(node: Option<Rc<RefCell<TreeNode>>>, min: i64, max: i64) -> bool {
        match node {
            None => true, // base case null node valide
            Some(node) => {
                let n = node.borrow();
                if (n.val as i64) <= min || (n.val as i64) >= max {
                    return false;
                }
                Self::validate(n.left.clone(), min, n.val as i64)
                    && Self::validate(n.right.clone(), n.val as i64, max)
            }
        }
    }

}

fn main() {
    // Valid BST:
    //     2
    //    / \
    //   1   3
    let root1 = Some(Rc::new(RefCell::new(TreeNode {
        val: 2,
        left: Some(Rc::new(RefCell::new(TreeNode::new(1)))),
        right: Some(Rc::new(RefCell::new(TreeNode::new(3)))),
    })));
    println!("{}", Solution::is_valid_bst(root1)); // expect: true

    // Invalid BST:
    //     5
    //    / \
    //   1   4
    //      / \
    //     3   6
    let root2 = Some(Rc::new(RefCell::new(TreeNode {
        val: 5,
        left: Some(Rc::new(RefCell::new(TreeNode::new(1)))),
        right: Some(Rc::new(RefCell::new(TreeNode {
            val: 4,
            left: Some(Rc::new(RefCell::new(TreeNode::new(3)))),
            right: Some(Rc::new(RefCell::new(TreeNode::new(6)))),
        }))),
    })));
    println!("{}", Solution::is_valid_bst(root2)); // expect: false
}
