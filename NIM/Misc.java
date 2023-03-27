package NIM.misc;

import java.util.Random;
import java.util.Scanner;

public class Misc {
    public Misc() {
    }


    public static int user_input_int(Scanner user_scan, int high, int low) {
        int user_input = 0;

        boolean isInvalid = true;
        while (isInvalid || (user_input < low || user_input > high)) {
            try {

                user_input = user_scan.nextInt();
                
                isInvalid = false;
            } catch (Exception e) {
                System.out.println("It was not an integer.");
                user_scan.next();
            } finally {

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

