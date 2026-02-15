fn main() {
    // branches();
    // repeatation();
    // loop_lables();
    // while_loop_example();
    // for_loop_example();
    for_with_rev();

}

fn repeatation(){
    let mut counter = 0;
    let result = loop {
        counter += 1;

        if counter == 100 {
            break counter * 2;
        }
    };

    println!("The result is {result}");
}

fn loop_lables(){
    let mut count = 0;
    'counting_up: loop {
        println!("count = {count}");
        let mut remaining = 10;
        loop {
            println!("remaining = {remaining}");
            if remaining == 9 {
                break;
            } 
            if count == 2 {
                break 'counting_up;
            }
            remaining -= 1;
        }
        count += 1;
    }
    println!("End count = {count}")
}

fn while_loop_example() {
    let mut number = 3;
    while number != 0 {
        println!("{number}");
        number -= 1;
    }

    println!("LIFTOFF!");
}

fn for_loop_example() {
    let a = [1,2,3,4,5];
    for element in a {
        println!("the value is: {element}");
    }
}

fn for_with_rev(){
    for number in (1..4).rev(){
        println!("{number}");
    }
    println!("LIFOFF!!!");
}

fn branches(){
    let number = 6;
    if number % 4 == 0 {
        println!("number is divisible by 4");
    } else if number % 3 == 0 {
        println!("number is divisible by 3");
    } else if number % 2 == 0 {
        println!("number is divisible by 2");
    } else {
        println!("number is not divisible by 4, 3, 2");
    }

    let condition = true;
    let number = if condition {5} else {6};

    println!("The value of number is: {number}");
}
