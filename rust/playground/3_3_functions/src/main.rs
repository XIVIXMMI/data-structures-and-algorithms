fn main() {
    let a = five();
    let x = plus_one(4);
    another_function(a);
    another_function(x);
    print_labeled_measurement(a,'h');
}

fn another_function(x: i32){
    println!("The value of the parameter: {x}");
}

fn print_labeled_measurement(value: i32, unit_label: char) {
    println!("The measurement is: {value}{unit_label}");
}

fn five() -> i32 {
    5
}

fn plus_one(x: i32) -> i32 {
    x + 1
}
