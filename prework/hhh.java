package Hspexample;

import java.util.Random;
import java.util.Scanner;

public class hhh {

    public static int user_input_int(Scanner user_scan, int high, int low) {
        int user_input = 0;
        //try catch is a block code that will allow you to
        // manage possible issues.
        boolean isInvalid = true;
        while(isInvalid || (user_input < low || user_input > high)) {
            try {
                System.out.println("Enter an integer between " + low + " and " + high);
                user_input = user_scan.nextInt();

                //if input is mismatched the exception occurs here
                isInvalid = false;
            }catch(Exception e) {
                System.out.println("That was not an integer.");
                user_scan.next();
            }finally {

            }
        }

        return user_input;
    }

    public static int gen_random_int_ranged(int min, int max) {
        Random rand = new Random();
        int rand_num = rand.nextInt();
        rand_num = Math.abs(rand_num);
        rand_num = (rand_num % (max - min + 1)) + min;
        return rand_num;
    }
}
