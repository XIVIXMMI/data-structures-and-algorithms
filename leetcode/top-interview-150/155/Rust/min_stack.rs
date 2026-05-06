struct MinStack {
    main_stack: Vec<i32>,
    min_stack: Vec<i32>,
}


/** 
 * `&self` means the method takes an immutable reference.
 * If you need a mutable reference, change it to `&mut self` instead.
 */
impl MinStack {

    fn new() -> Self {
        Self {
        main_stack: Vec::new(),
        min_stack: Vec::new(),
    }
    }
    
    fn push(&self, val: i32) {
        self.main_stack.push(val);
        if let Some(top) = self.min_stack.last() {
            if val <= *top {
                self.min_stack.push(val);
            }
        } else {
            self.min_stack.push(val);
        }
    }
    
    fn pop(&self) {
        if let Some(top) = self.min_stack.last() {
            if Some(top) == self.main_stack.last() {
                self.min_stack.pop();
            }
        }
        self.main_stack.pop();
    }
    
    fn top(&self) -> i32 {
        self.main_stack.last().copied().unwrap()
    }
    
    fn get_min(&self) -> i32 {
        self.min_stack.last().copied().unwrap()
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * let obj = MinStack::new();
 * obj.push(val);
 * obj.pop();
 * let ret_3: i32 = obj.top();
 * let ret_4: i32 = obj.get_min();
 */