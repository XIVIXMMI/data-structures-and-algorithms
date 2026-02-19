fn main() {
                    // s is not valid here, since it's not yet declare
    let s = "hello";// s is valid from this point forward
    // do stuff with s

    let s = String::from("hello");  // s comes into scope

    takes_ownership(s);             // s's value moves into the function...
                                    // ... and so is no longer valid here

    let x = 5;                      // x comes into scope

    makes_copy(x);                  // Because i32 implements the Copy trait,
                                    // x does NOT move into the function,
                                    // so it's okay to use x afterward.


} // this scope is over now, and s is no longer valid
// Here, x goes out of scope, then s. However, because s's value was moved,
  // nothing special happens.

// fn the_string_type(){
//
//     let s = String::from("hello");
//
//     s.push_str(", world!"); // push_str() appends a literal to a String
//
//     println!("{s}"); // this will print `hello, world!`
//
// }
//
// fn string_type_example(){
//         let s = String::from("hello"); // s is valid from this point forward
//
//         // do stuff with s
// }                                  // this scope is now over, and s is no
//                                        // longer valid
// fn expected_error(){
//     let s1 = String::from("hello");
//     let s2 = s1;
//
//     println!("{s1}, world!");
//
// }

// Here, x goes out of scope, then s. However, because s's value was moved,
  // nothing special happens.

fn takes_ownership(some_string: String) { // some_string comes into scope
    println!("{some_string}");
} // Here, some_string goes out of scope and `drop` is called. The backing
  // memory is freed.

fn makes_copy(some_integer: i32) { // some_integer comes into scope
    println!("{some_integer}");
} // Here, some_integer goes out of scope. Nothing special happens.

