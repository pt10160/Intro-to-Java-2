package NIM.game;
import java.util.Scanner;
import NIM.Mian.Computer;
import NIM.Mian.Human;
import NIM.misc.Misc;
import NIM.Mian.judge;
public class Game {

    private judge Computer;
    private judge Human;
    private Scanner scan;
    private boolean game_over;
    public static int step;
    public static int max =NIM.misc.Misc.gen_random_int_ranged(50, 300);
    public static int left = max;
    public int getleft(int step) {
        System.out.println(step);
        this.left = this.left-step;
        return this.left;
    }

    public Game(Scanner scan) {
        this.scan=scan;
    }
    public void play_game() {
        initialize_game();
        while(!this.game_over) {
            take_turn();
        }
    }
    private void take_turn() {
        this.take_human_turn();
        if(!game_over) {
            this.take_computer_turn();
        }
    }
    private void take_human_turn() {

        int step = this.Human.getStep();
        this.check_win(step,this.Human.getName(),getleft(step));
    }
    private void take_computer_turn() {
        int step = this.Computer.step();
        this.check_win(step,this.Computer.getName(),getleft(step));
    }
    private void check_win(int step,String name,int left) {
        int step_difference =Math.abs(left-this.step);
        System.out.println("sdfaasdf " + step_difference);
        if(step_difference ==0) {
            this.game_over =true;
            System.out.println(name +"wins");
        }else {
            if(step_difference>0) {
                System.out.println(name +step+"step");
                System.out.println(left-this.step+"is left");

            }
        }
    }

    private void initialize_game() {
        this.game_over = false;
        initialize_player();
    }

    private void initialize_player() {
        initialize_human_player();
        initialize_computer_player();
    }
    private void initialize_human_player() {
        System.out.println("enter the name of your player.");
        String name = scan.nextLine();
        this.Human = new Human(name,this.scan);

    }
    private void initialize_computer_player() {
        String name ="CC";
        this.Computer = new Computer(name);
    }


}
