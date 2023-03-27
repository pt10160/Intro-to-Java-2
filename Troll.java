package Game;

public class Troll extends Offensive {
    private double chance_to_roll;

    public Troll(String name, int max_hp, int x_coord, int y_coord, double base_chance, int do_damage_max, int do_damage_min, int direction, double chance_to_regen, int min_regen, int max_regen, double chance_to_roll) {
        super(name,max_hp,x_coord,y_coord,base_chance,do_damage_max,do_damage_min,direction,chance_to_regen,min_regen,max_regen);
    this.chance_to_roll=chance_to_roll;
    get_facing();
    }
    private int get_facing(){
        String[] troll_arr = this.toString().split("\n");
        String[] facing_arr = troll_arr[1].split(" ");
        if(facing_arr[1].compareTo("North")==0){
            return 1;
        }else if(facing_arr[1].compareTo("East")==0){
            return 2;
        }else if(facing_arr[1].compareTo("South")==0){
            return 3;
        }else if(facing_arr[1].compareTo("West")==0){
            return 4;
        }else{
            return 0;
        }
    }
    /*@Override
    public int make_choice(int[] enemy_location){
        int choice =0;
        int dif_x=(enemy_location[0]-this.get_location()[0]);
        int dif_y= (enemy_location[1]-this.get_location()[1]);
        int can_attack = Math.abs(dif_x)+Math.abs(dif_y);
        int current_direction = super.get_direction();
        change_direction(enemy_location);
        int new_direction = super.get_direction();
        if(current_direction==new_direction&& can_attack==1){
            choice =2;
        }else if(current_direction == new_direction){
            choice =1;
        }
        return choice;
    }

     */
    private int[] get_new_solution(int[] solution){
        int facing = get_facing();
        int[] new_solution = new int[5];
        new_solution[0] = solution[0];
        new_solution[1] = solution[1];
        new_solution[4] = solution[2];
        switch(facing){
            case 1:
                new_solution[2] = super.set_vars(0, 7,(solution[0] - 1));
                new_solution[3] =  solution[1];
                break;
            case 2:
                new_solution[2] = solution[0];
                new_solution[3] = super.set_vars(0, 7,(solution[1] + 1));
                break;
            case 3:
                new_solution[2] = super.set_vars(0, 7,(solution[0] + 1));
                new_solution[3] = solution[1];
                break;
            case 4:
                new_solution[2] = solution[0];
                new_solution[3] = super.set_vars(0, 7,(solution[1] - 1));
                break;
        }
        return new_solution;
    }
    @Override
    public int[] attack() {

        int[] solution = super.attack();
        if(super.successful_action(chance_to_roll)){
            System.out.println(super.get_name() +
                    " rolls a boulder at you!");
            int[] new_solution =
                    this.get_new_solution(solution);
            return new_solution;
        }else{
            return solution;
        }
    }
    @Override
    public String toString(){
        String info = "the troll "+super.toString();
        return info;
    }





}
