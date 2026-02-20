fn main() {
    let s1 = String::from("hello");

    println!("The length of '{s1}' is {len}.");
}

/**
* if we wouldn't use '&'
* String is place on heap
* When passing s1 value into function
* OWNERSHIP would be move into the function 
* After function is out of scope -> s will be drop
* s1 won't be able to use. 
* ===============================================
* And if we use '&'
* &s1 mean borrow s1
* Ownership still belong to s1 
* Function only read the value
* After function of scope 
* s1 still exists.
*/
fn calculate_length(s: &String) -> usize { // s is a reference to a String
    s.len()
} // Here, s goes out of scope. But because s does not have ownership of what
  // it refers to, the String is not dropped.
