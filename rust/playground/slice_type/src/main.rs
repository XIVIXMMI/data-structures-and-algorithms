fn main() {
    let mut s = String::from("Hello world");
    let word = first_word_new(&s);
    // let word = first_word(&s);

    s.clear();

    println!("the first word is: {word}");
}

fn first_word(s: &String) -> usize {
    let bytes = s.as_bytes();
    for(i, &item) in bytes.iter().enumerate() {
        if item == b' ' {
            return i;
        }
    }
    s.len()
}


fn first_word_new(s: &String) -> &str {
    let bytes = s.as_bytes();
    for(i, &item) in bytes.iter().enumerate() {
        if item == b' ' {
            return &s[0..i];
        }
    }
    &s[..]
}

// fn two_word(s: &String) -> (usize,usize){
//
// }
