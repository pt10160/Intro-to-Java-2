package Chicken;

/**
 * @version 1.0
 * @authoer Martin
 */
public class Computer extends Ijudge {
    private  String name;
    private  int x_coord;
    private  int y_coord;
    private  int direction;

    public Computer(String name, int x_coord, int y_coord, int direction) {
        super(name, x_coord, y_coord, direction);
        this.name = name;
        this.x_coord = x_coord;
        this.y_coord = y_coord;
        this.direction = direction;// int

    }



    @Override
    public void hit(int damage){
        super.hit(1);

    }
    @Override
    public String toString(){
        String info = "the human";
        info +=super.toString();
        return info;

    }
}
