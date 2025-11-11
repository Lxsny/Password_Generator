
import java.util.Scanner;

public class test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("-- Welcome to the password generator/checker! --");
        System.out.println("Press 1 to generate a password to your liking ");
        System.out.println("Press 2 to check how secure your password is ");
        int num = sc.nextInt();
        while (true){
            if (num == 1) {
                System.out.print("What's the password length? ");
                int length = sc.nextInt();

                System.out.print("Include lowercase letters? (y/n): ");
                String lower = sc.next();
                boolean b1 = validation(lower);

                System.out.print("Include uppercase letters? (y/n): ");
                String upper = sc.next();
                boolean b2 = validation(upper);

                System.out.print("Include digits? (y/n): ");
                String digits = sc.next();
                boolean b3 = validation(digits);

                System.out.print("Include symbols? (y/n): ");
                String symbols = sc.next();
                boolean b4 = validation(symbols);

                String pass1 = passUtils.generator(length, b1, b2, b3, b4);
                System.out.println("Your password is: " + pass1);

                System.exit(0);
            } else if (num == 2) {
                System.out.print("Enter the password you want to check:  ");
                String password = sc.next();
                System.out.println(passUtils.checker(password));

                System.exit(0);
            } else {
                System.out.println("Please enter either 1 or 2 ");
                num = sc.nextInt();
            }
        }
    }

    public static boolean validation(String name){
        name = name.toLowerCase();
        if(name.equals("y") || name.equals("yes"))
        return true;

        return false;
    }
}
