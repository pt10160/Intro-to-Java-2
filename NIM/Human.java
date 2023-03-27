package NIM.Mian;
import NIM.game.Game;

import java.util.Scanner;

public class Human extends judge{
private Scanner scan;
private int step;
private int max;
    public int getmax(){
        int max = Game.max;
        return max;
    }
    public Human(String name,Scanner scan) {
        super(name);
        this.scan=scan;
    }
    public int getStep(){
        System.out.println("Enter an integer between " + 0 + " and " + (Game.left/2));
        int step = NIM.misc.Misc.user_input_int(scan,(Game.left/2+1),0);
        return step;
    }
}
