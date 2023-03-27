package Chicken;

import java.util.Random;
import java.util.Scanner;

/**
 * @version 1.0
 * @authoer Martin
 */

public class Ijudge implements Judge {

    private String name;
    private int x_coord;
    private int y_coord;
    private int current_hp;
    private int H_direction;
    private int C_direction;
    private char symbol;
    private Scanner scan;
    private boolean game_over;
    private int xy=0;
    private int xx=0;
    private int yy=7;
    private int yx=7;




    public void play_game(){
        initialize_game();
        while(!this.game_over){
            take_turn();
        }
        System.out.println("game over,chicken get shot");

    }
    public Ijudge(Scanner scan){
        this.scan = scan;
    }
    public Ijudge(String name, int x_coord, int y_coord, int direction){
        this.name = name;
        this.symbol = this.name.charAt(0);
        this.x_coord =x_coord;
        this.y_coord=y_coord;
        this.H_direction = direction;
        this.C_direction = direction;

    }
    public void take_human_turn(int direction,int x_coord,int y_coord) {
        System.out.println("what do you want to do 1 = move,2 = attack,3 = change");
        int answer = scan.nextInt();
        switch (answer) {
            case 1:
                move("human",xy,xx,direction);
                System.out.println("daodafadsf"+direction);
                break;
            case 2:
                attack("human",xx,xy, yx,yy,direction);
                break;
            case 3:
                change_direction(direction,"human");
                break;
        }

    }
    public void take_computer_turn(int direction,int x_coord,int y_coord){
        if(direction ==0){
            direction++;
        }
        System.out.println("computer to move");
        int answer = Misc.gen_random_int_ranged(1,3);
        switch (answer) {
            case 1:
                try {
                    move("computer", yy, yx, direction);
                }catch(Exception e){
                    System.out.println("if you move this game will be over");
                   change_direction(direction,"computer");
                }
                break;
            case 2:
                attack("computer",xx,xy, yx,yy,direction);
                break;
            case 3:
                System.out.println("this is"+direction);
                change_direction(direction,"computer");
                break;
        }

    }
    private void initialize_game() {
        this.game_over = false;

    }


    private void check_win(String name,int life){
        if (life ==0){
            this.game_over = true;
        }else{
            System.out.println("this game still not donw yet");
        }
    }

    private void take_turn() {
        System.out.println("????"+getH_Direction());//1
        this.take_human_turn(getH_Direction(),0,0);

        if(!game_over) {

            System.out.println(getC_Direction());
            this.take_computer_turn(getC_Direction(),7,7);


        }
    }

    @Override
    public int[] get_location(){
        int[] location = new int[2];
        location[0] = this.x_coord;
        location[1] = this.y_coord;
        return location;

    }
    @Override
    public void change_direction(int direction,String name) {
        Scanner ok = new Scanner(System.in);
        int gg =ok.nextInt();
        if(name =="human") {
            int new_direction = getH_Direction() + gg;

            if (new_direction > 4 || new_direction < 1) {
                new_direction = Math.abs(new_direction % 4) + 1;
            }
            this.H_direction = new_direction;
        }
        else{

            int new_direction = getC_Direction() + gg;
            if (new_direction > 4 || new_direction < 1) {
                new_direction = Math.abs(new_direction % 4) + 1;
            }
            this.C_direction = new_direction;
        }
    }

    @Override
    public void move(String name,int x_coord,int y_coord,int direction) {
        Board board = new Board(8,8);
        board.mark_board(xy , xx,'h');
        board.mark_board(yy, yx, 'x');



        if(name == "human") {

            switch (direction) {
                case 1:


                    board.mark_board(xy-1 , xx,'h');
                    board.mark_board(xy, xx, ' ');

                    xy--;

                    break;
                case 2:
                    board.mark_board(xy, xx+1, 'h');
                    board.mark_board(xy, xx, ' ');
                    xx++;
                    break;

                case 3:
                    board.mark_board(xy+1, xx, 'h');
                    board.mark_board(xy, xx, ' ');
                    xy++;
                    break;

                case 4:
                    board.mark_board(xy, xx-1, 'h');
                    board.mark_board(xy, xx, ' ');
                    xx--;
                    break;


            }

            board.display_board();
        }
        else if(name =="computer"){

            switch (direction) {
                case 1:


                    board.mark_board(yy-1 , yx,'x');
                    board.mark_board(yy, yx, ' ');

                    yy--;

                    break;
                case 2:
                    board.mark_board(yy, yx+1, 'x');
                    board.mark_board(yy, yx, ' ');
                    yx++;
                    break;

                case 3:
                    board.mark_board(yy+1, yx, 'x');
                    board.mark_board(yy, yx, ' ');
                    yy++;
                    break;

                case 4:
                    board.mark_board(yy, yx-1, 'x');
                    board.mark_board(yy, yx, ' ');
                    yx--;
                    break;


            }

            board.display_board();
        }




    }

    @Override
    public boolean attack(String name,int xx,int xy,int yx,int yy,int direction) {
        if(name == "computer"){
            switch (direction) {
                case 1:
                    int point = xy-2;
                    if(point >=yy||xx==yx){
                        System.out.println("human just get shot");
                        break;
                    }
                    break;
                case 2:
                    int point2 = xx+2;
                    if(point2 <=yx||xy==yy){
                        System.out.println("human just get shot");
                        break;
                    }
                    break;
                case 3:
                    int point3 = xy+2;
                    if(point3 <=yy||xx==yx){
                        System.out.println("human just get shot");
                        break;
                    }
                    break;
                case 4:
                    int point4=xx-2;
                    if(point4<=yx||xy==yy){
                        System.out.println("human just get shot");
                        break;
                    }

                    break;


            }
            hit(1);
            check_win("human",1);
            return true;
        }
        if(name == "human"){
            switch (direction) {
                case 1:
                    int point = xy-2;
                    if(point >=yy||xx==yx){
                        System.out.println("computer just get shot");
                        break;
                    }
                    break;
                case 2:
                    int point2 = xx+2;
                    if(point2 <=yx||xy==yy){
                        System.out.println("computer just get shot");
                        break;
                    }
                    break;
                case 3:
                    int point3 = xy+2;
                    if(point3 <=yy||xx==yx){
                        System.out.println("computer just get shot");
                        break;
                    }
                    break;
                case 4:
                    int point4=xx-2;
                    if(point4<=yx||xy==yy){
                        System.out.println("computer just get shot");
                        break;
                    }

                    break;


            }
            hit(1);
            check_win("computer",1);
            return true;
        }
        else{
            return false;
        }

    }

    public String getName(){
        return name;
    }
    public char getSymbol(){
        return symbol;
    }
    public int getH_Direction(){
        return H_direction;
    }
    public int getC_Direction(){
        return C_direction;
    }
    public boolean is_alive(){
        return this.current_hp>0;
    }
    public void hit(int damage){
        this.current_hp = current_hp -1;
    }
    @Override
    public int set_vars(int min,int max,int var){
        if(var<min){
            var=min;
        }else if(var>max){
            var=max;
        }
        return var;
    }
    private int[] increment_east(){
        int x = set_vars(0,7,this.x_coord+2);
        int[] new_increment ={this.y_coord,x};
        return new_increment;
    }
    private int[] increment_west(){
        int x = set_vars(0,7,this.x_coord-2);
        int[] new_increment ={this.y_coord,x};
        return new_increment;
    }

    private int[] increment_north(){
        int y = set_vars(0,7,this.y_coord+2);
        int[] new_increment ={y,x_coord};
        return new_increment;
    }
    private int[] increment_south(){
        int y = set_vars(0,7,this.y_coord-2);
        int[] new_increment ={y,this.x_coord};
        return new_increment;
    }
    private String facing(String name){
        if(name=="human") {
            switch (this.getH_Direction()) {
                case 1:
                    return "north";
                case 2:
                    return "east";
                case 3:
                    return "south";
                case 4:
                    return "West";
                default:
                    return "Error";
            }
        }else{

        }
        return "hh";
    }

    @Override
    public String toString(){
        String info = "sdhfhsadoif"+this.name + "\n";
        info += "is facing "+ facing("human") +"\n";
        info += "Has " + this.current_hp+ "hp\n";
        info += "and is standing at "+this.x_coord+","+this.y_coord;
        return info;
    }


}