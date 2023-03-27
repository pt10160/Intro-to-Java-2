package Chicken;

/**
 * @version 1.0
 * @authoer Martin
 */
public class Board {
    private char[][] board;
    private int rows,columns;
    public Board(int rows,int columns){
        this.rows = rows;
        this.columns = columns;
        this.board = new char[rows][columns];

    }

    public void initialize_board(){
        for(int i =0;i < rows;i++){
            for(int j =0; j<columns;j++){
                board[i][j] = ' ';
            }
        }
    }
    public void display_board(){
        String horizontal_bar = "+";
        String top_line = "╔===╦===╦===╦===╦===╦===╦===╦===╗";
        String middle_line = "╠===╬===╬===╬===╬===╬===╬===╬===╣";
        String bottom_line = "╚===╩===╩===╩===╩===╩===╩===╩===╝";

        System.out.println(top_line);
        for(int i = 0;i<rows;i++){
            for(int j = 0;j< columns;j++){

                System.out.print(horizontal_bar +" "+ board[i][j]+" ");
            }
            System.out.print(horizontal_bar);
            System.out.println();
            if(i ==rows-1){
                System.out.println(bottom_line);
            }else{
                System.out.println(middle_line);
            }
        }


    }
    public void mark_board(int y,int x,char symbol){

        board[y][x]=symbol;
    }
}
