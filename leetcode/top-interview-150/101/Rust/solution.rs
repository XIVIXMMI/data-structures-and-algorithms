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
    pub fn is_symmetric(root: Option<Rc<RefCell<TreeNode>>>) -> bool {
        match (root){
            None => true,
            Some(root) => {
                let node = root.borrow();
                Self::is_mirror(node.left.clone(), node.right.clone())
            }
        }
    }

    pub fn is_mirror(
        left: Option<Rc<RefCell<TreeNode>>>, 
        right: Option<Rc<RefCell<TreeNode>>>) -> bool {
        match (left, right) {
            (None, None) => true,
            (None, Some(_)) | (Some(_), None) => false,
            (Some(l),Some(r)) => {
                let left = l.borrow();
                let right = r.borrow();
                if left.val != right.val {
                    return false;
                }
                Self::is_mirror(left.left.clone(), right.right.clone()) && Self::is_mirror(left.right.clone(), right.left.clone())
            }
        }
    }
}
