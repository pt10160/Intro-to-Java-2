package NIM.box;
import java.util.Scanner;
import NIM.game.Game;


public class box_main  {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Game the_game = new Game(scan);
        System.out.println("here is"+ Game.left+" much step,you can go bettwen 0 and "+(Game.left/2)+"step");

        the_game.play_game();

    }
}
