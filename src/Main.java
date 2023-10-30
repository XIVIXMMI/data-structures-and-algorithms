import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner =  new Scanner(System.in);

        System.out.println("What's your name? ");
        String Name = scanner.nextLine();
        System.out.println("How old are you? ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("What your favorite food? ");
        String food = scanner.nextLine();

        System.out.println("Hello "+Name);
        System.out.println("You are "+age+" years old");
        System.out.println("You like "+food);

    }
}
