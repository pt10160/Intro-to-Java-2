package NIM.Mian;


import NIM.game.Game;

public class Computer extends judge {
    public Computer(String name){

        super(name);
    }

    public int step(){
        int step = NIM.misc.Misc.gen_random_int_ranged(0,(Game.left/2+1));
        setStep(step);
        System.out.println("Give an interger between " + 1 + " and " + (Game.left/2));
        if(step> Game.left){
            step = Game.left/2;
        }else{
            step =step;
        }
        return step;
    }
}
