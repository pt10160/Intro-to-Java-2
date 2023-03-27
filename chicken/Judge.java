package Chicken;/**
 *@authoer Martin
 *@version 1.0
*/
public interface Judge {
    public void move(String name,int x,int y,int direction);
    public boolean attack(String name,int xx,int xy,int yx,int yy,int direction);
    public void change_direction(int direction,String name);
    public int[] get_location() ;
    public boolean is_alive();
    public int set_vars(int min,int max,int var);


}
