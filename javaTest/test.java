import java.util.Scanner;
import java.util.InputMismatchException;

public class TicTacToe {

  // main varibles of game
  static String[] boardArea = new String[8];
  static String[] playerInputs = new String[9]; 
  static String[] playerTure;

  // winning conditions  
  static int[][] winnerStatments = new int[][]{{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

  public static void printBoard(){

    // clear the console
    System.out.print("\033[H\033[2J"); 
    System.out.flush();

    // printing  the area of game
    System.out.println("        |        |       ");
    System.out.println("   "+playerInputs[0]+"   |   "+playerInputs[1]+"   |  "+playerInputs[2]+"  ");
    System.out.println("        |        |        ");
    System.out.println("--------|--------|--------");
    System.out.println("        |        |       ");
    System.out.println("   "+playerInputs[3]+"   |   "+playerInputs[4]+"   |  "+playerInputs[5]+"  ");
    System.out.println("        |        |       ");
    System.out.println("--------|--------|--------");
    System.out.println("        |        |       ");
    System.out.println("   "+playerInputs[6]+"   |   "+playerInputs[7]+"   |  "+playerInputs[8]+"  ");
    System.out.println("        |        |       ");
  }

  public void initValues(){

    for(int i=0;i<playerInputs.length;i++){
      this.playerInputs[i] = "  ";
    }
  }

  public void getInput(){

    Scanner sc = new Scanner(System.in);
    System.out.println("Enter your Box number:");
    int x = 1; 

    do{
      try{

        

          x = sc.nextInt();
          x--;
          playerInputs[x] = "❌";


        //  🟡

        printBoard(); 

      } catch(InputMismatchException e){      

        System.out.println("oops..🚯 entered value is not number..");
      } catch(ArrayIndexOutOfBoundsException e){

        System.out.println("🤠 Hey dude, Enter a valid number");
      } catch(IllegalArgumentException e){

        System.out.println("The field is already occupied.");
      }

    }while(this.playerInputs[x] != "  ");
  }

  public static void main(String[] args) {

    TicTacToe game = new TicTacToe();
    game.initValues();
    game.printBoard();
    game.getInput();
   
  }
}

