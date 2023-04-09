import java.util.Scanner;
import java.util.InputMismatchException;

public class TicTacToe {

  // main varibles of game
  static String[] boardArea = new String[8];
  static String[] gameArea = new String[9]; 
  static String[] playerTure;
  static String mainPlayer   = "❌";
  static String  computer = "🟡";
  static String spaces = "  ";

  // colors
  static final String RESET = "\u001B[0m";
  static final String BLACK = "\u001B[30m";
  static final String RED = "\u001B[31m";
  static final String GREEN = "\u001B[32m";
  static final String YELLOW = "\u001B[33m";
  static final String BLUE = "\u001B[34m";
  static final String MAGENTA = "\u001B[35m";
  static final String CYAN = "\u001B[36m";
  static final String WHITE = "\u001B[37m";

  // Background colors
  static final String BGC_RED = "\u001B[41m";
  static final String BGC_GREEN = "\u001B[42m";
  static final String BGC_YELLOW = "\u001B[43m";
  static final String BGC_BLUE = "\u001B[44m";
  static final String BGC_MAGENTA = "\u001B[45m";
  static final String BGC_CYAN = "\u001B[46m";
  static final String BGC_WHITE = "\u001B[47m";

  // Text styles
  static final String BOLD = "\u001B[1m";
  static final String ITALIC = "\u001B[3m";
  static final String UNDERLINE = "\u001B[4m";


  // winning conditions  
  static int[][] winnerStatments = new int[][]{{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

  public static void printBoard(){

    // clear the console
    System.out.print("\033[H\033[2J"); 
    System.out.flush();

    // printing  the area of game
    System.out.println("\n         |        |       ");
    System.out.println("    "+gameArea[0]+"   |   "+gameArea[1]+"   |  "+gameArea[2]+"  ");
    System.out.println("         |        |        ");
    System.out.println(" --------|--------|--------");
    System.out.println("         |        |       ");
    System.out.println("    "+gameArea[3]+"   |   "+gameArea[4]+"   |  "+gameArea[5]+"  ");
    System.out.println("         |        |       ");
    System.out.println(" --------|--------|--------");
    System.out.println("         |        |       ");
    System.out.println("    "+gameArea[6]+"   |   "+gameArea[7]+"   |  "+gameArea[8]+"  ");
    System.out.println("         |        |      \n");
  }

  public int chackIsAreaFull(){

    int isAreaFull = 9;

    for(int i =0 ;i<gameArea.length;i++){
      if(gameArea[i] ==spaces){ 
        isAreaFull--;
      }
    }
    return isAreaFull;
  }


  public void initValues(){

    for(int i=0;i<gameArea.length;i++){
      gameArea[i] =spaces; 
    }
  }

  public void checkWinner(String winner){
    if(winner == computer){
      System.out.println("😝 So sad,Try next time"+RESET);
    }else if(winner == mainPlayer){
      System.out.println("👑 Hey, Nice played you win"+RESET);
    }else{
      System.out.println("😞 It's a Tie!, What a shame"+RESET);
    }
  }

  public void getInput(){

    Scanner sc = new Scanner(System.in);
    int x = 1; 

    do{

      try{

        System.out.print("  "+BGC_GREEN+BLACK+"Enter your Box number:"+RESET+" ");
        x = sc.nextInt();
        x--;
        gameArea[x] = computer;
        printBoard(); 

      } catch(InputMismatchException e){      

        System.out.println(BGC_RED+BLACK+ "\noops..🚯 entered value is not number.."+RESET);
        sc.next(); // consume the non-integer input and clear the Scanner buffer
      } catch(ArrayIndexOutOfBoundsException e){

        System.out.println(BGC_YELLOW+BLACK+"\n🤠 Hey dude, Enter a valid number"+RESET);
      } 
    }while(gameArea.length != chackIsAreaFull());
  }

  public static void main(String[] args) {

    TicTacToe game = new TicTacToe();
    game.initValues();
    game.printBoard();
    game.getInput();

  }
}

