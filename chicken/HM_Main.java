package Chicken;

import java.util.Scanner;

/**
 * @version 1.0
 * @authoer Martin
 */
public class HM_Main {
    public static void main(String[] args) {
        System.out.println("the first move you have to choose the direction first");
        System.out.println("press 3  to initialize the game");
        Scanner scan = new Scanner(System.in);
        Ijudge the_game = new Ijudge(scan);


        the_game.play_game();



    }
}
