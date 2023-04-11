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
  static String winner = new String();

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

  public final static void printBoard(){

    // clear the console
    System.out.print("\033[H\033[2J"); 
    System.out.flush();

    // There is two way to printing  the area of game 1st one see down below

    // System.out.println(GREEN+"\n         |        |       "+RESET);
    // System.out.println(GREEN+"    "+gameArea[0]+"   |   "+gameArea[1]+"   |  "+gameArea[2]+"  "+RESET);
    // System.out.println(GREEN+"         |        |        "+RESET);
    // System.out.println(GREEN+" --------|--------|--------"+RESET);
    // System.out.println(GREEN+"         |        |       "+RESET);
    // System.out.println(GREEN+"    "+gameArea[3]+"   |   "+gameArea[4]+"   |  "+gameArea[5]+"  "+RESET);
    // System.out.println(GREEN+"         |        |       "+RESET);
    // System.out.println(GREEN+" --------|--------|--------"+RESET);
    // System.out.println(GREEN+"         |        |       "+RESET);
    // System.out.println(GREEN+"    "+gameArea[6]+"   |   "+gameArea[7]+"   |  "+gameArea[8]+"  "+RESET);
    // System.out.println(GREEN+"         |        |      \n"+RESET);

    // here is the second one.
    for (int row = 0; row < 3; row++) {
      System.out.println(GREEN + "         |        |        " + RESET);
      System.out.println(GREEN + "    " + gameArea[row * 3] + "   |   " + gameArea[row * 3 + 1] + "   |  " + gameArea[row * 3 + 2] + "  " + RESET);
      System.out.println(GREEN + "         |        |        " + RESET);

      if (row != 2) {
        System.out.println(GREEN + " --------|--------|--------" + RESET);
      }
    }
    System.out.println();
  }

  public final  int chackIsAreaFull(){
    int isAreaFull = 9;

    for(int i =0 ;i<gameArea.length;i++){
      if(gameArea[i] ==spaces){ 
        isAreaFull--;
      }
    }
    return isAreaFull;
  }

  public final  void initValues(){

    for(int i=0;i<gameArea.length;i++){
      gameArea[i] = spaces; 
    }
  }

  public final void checkWinner(String winner){
    if(winner.equals(computer)){
      System.out.println("😝 So sad,Try next time"+RESET);
    }else if(winner.equals(mainPlayer)){
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

        System.out.print("  "+BOLD+BGC_GREEN+BLACK+"Enter your Box number:"+RESET+" ");
        x = sc.nextInt();
        x--;
        gameArea[x] = computer;
        printBoard(); 

        checkWinner(computer);
      } catch(InputMismatchException e){      

        System.out.println(BOLD+BGC_RED+BLACK+ "\noops..🚯 entered value is not number.."+RESET);
        sc.next();     // consume the non-integer input and clear the Scanner buffer
        
      } catch(ArrayIndexOutOfBoundsException e){

       System.out.println(BOLD+BGC_YELLOW+BLACK+"\n🤠 Hey dude, Enter a valid number"+RESET);
      } 

    }while((gameArea.length != chackIsAreaFull()) && winner.isEmpty()); 
  }

  public static void main(String[] args) {

    TicTacToe game = new TicTacToe();
    game.initValues();
    game.printBoard();
    game.getInput();

  }
}

