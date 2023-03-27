package Game;

import NIM.misc.Misc;

public class Warrior extends Defensive {
    private double chance_to_crush;

    public Warrior(String name, int max_hp, int x_coord, int y_coord, double base_chance, int do_damage_max, int do_damage_min, int direction, double chance_to_block, double chance_to_crush) {
        super(name, max_hp, x_coord, y_coord, base_chance, do_damage_max, do_damage_min, direction, chance_to_block);
    this.chance_to_crush=chance_to_crush;
    }


    @Override
    public int[] attack(){
        int[] sub_solution = super.attack();
        int damage =sub_solution[2];
        int roll= Misc.gen_random_int_ranged(1,20);
        if(roll==1){
            hit(damage);
            damage =0;
            System.out.println("you slipped and cut yourslef");
        }else if(roll ==20){
            damage+=100;
            System.out.println("what a mighty swing");
        }else {
            if (super.successful_action(chance_to_crush)&&damage >0) {
                System.out.println(super.get_name() + "swings and crushes the opponent");
                damage += damage * this.chance_to_crush;
            }
        }
        sub_solution[2]=damage;
        return sub_solution;
    }

   @Override
    public String toString(){
        String info ="the warrior "+ super.toString();
        return info;
   }
}
