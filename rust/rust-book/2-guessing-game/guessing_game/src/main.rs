use rand::Rng;
use std::cmp::Ordering;
use std::io::stdin; // the prlude
fn main() {
    println!("Guess the number!!");
    let secret_number = rand::thread_rng().gen_range(1..=10);
    loop {
        println!("The secret number is {secret_number}");
        println!("Please input your guess. ");

        let mut guess = String::new(); // bind guess to a new instance of string

        stdin().read_line(&mut guess).expect("Failed to read line!");

        let guess: i32 = match guess.trim().parse(){
            Ok(num) => num,
            Err(_) => continue,
        };

        println!("Your guess: {guess}");

        match guess.cmp(&secret_number) {
            Ordering::Equal => {
                println!("You Win!!");
                break;
            }
            Ordering::Greater => println!("Too Big"),
            Ordering::Less => println!("Too Small"),
        }
    }
}
