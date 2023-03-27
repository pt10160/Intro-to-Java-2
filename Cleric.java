package Game;

public class Cleric extends Defensive {

    private double chance_to_heal;
    private int min_heal;
    private int max_heal;
    private int c_max_hp;

    public Cleric(String name, int max_hp, int x_coord,
                  int y_coord, double base_chance,
                  int do_damage_max, int do_damage_min,
                  int direction, double chance_to_block,
                  double chance_to_heal, int min_heal,
                  int max_heal) {
        super(name, max_hp, x_coord, y_coord,
                base_chance, do_damage_max, do_damage_min,
                direction, chance_to_block);

        this.chance_to_heal = chance_to_heal;
        this.min_heal = min_heal;
        this.max_heal = max_heal;

    }
    @Override
    public int[] attack(){
        int healing =0;
        int[] solution =super.attack();
        int length =solution.length;
        String[] cleric_info = super.toString().split("\n");
        String[] hp_arr = cleric_info[2].split(" ");
        int hp =Integer.parseInt(hp_arr[2]);
        double health_percent = (double)hp/this.c_max_hp;
        if(health_percent<.6&& super.successful_action(chance_to_heal)){
            System.out.println(super.get_name()+"heals themself");
            solution[length-1]=0;
            healing =(NIM.misc.Misc.gen_random_int_ranged(min_heal,max_heal))*-1;
            super.hit(healing);
        }
        return solution;
    }
    @Override
    public String toString(){
        String cleric_info = "Cleric " + super.toString();
        return cleric_info;
    }




}

