import java.util.Scanner;
public class TicTacToe {

  // main varibles of game
  static String[][] boardArea = new String[8][3];
  static String[] playerInputs = new String[8]; 
  static String[] playerTure;
  static int[][] winnerStatments = new int[][]{{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

  public static void printBoard(){

    // clear the console
    System.out.print("\033[H\033[2J"); 
    System.out.flush();

    // printing  the area of game
    System.out.println("        |        |        ");
    System.out.println("   "+playerInputs[0]+"    |  "+playerInputs[1]+"  |  "+playerInputs[2]+"  ");
    System.out.println("        |        |        ");
    System.out.println("--------|--------|--------");
    System.out.println("        |        |        ");
    System.out.println("   "+playerInputs[0]+"    |  "+playerInputs[1]+"  |   "+playerInputs[2]+"  ");
    System.out.println("        |        |        ");
    System.out.println("--------|--------|--------");
    System.out.println("        |        |        ");
    System.out.println("   "+playerInputs[0]+"  |    "+playerInputs[1]+"  |    "+playerInputs[2]+"  ");
    System.out.println("        |        |        ");
  }

  public void initValues(){
    // winning conditions  
    for(int i=0;i<playerInputs.length;i++){
      this.playerInputs[i] = " ";
    }
  }

  public void getInput(){
    do{
      System.out.println("Enter your Box number:");
      Scanner sc = new Scanner(System.in);
      int x = sc.nextInt();

      x--;

      playerInputs[x] = "X";
      System.out.print("\033[H\033[2J");  
      System.out.flush();
      printBoard(); 

    }while(true);
  }

  public static void main(String[] args) {

    TicTacToe game = new TicTacToe();
    game.initValues();
    game.printBoard();
    game.getInput();
   
  }
}
