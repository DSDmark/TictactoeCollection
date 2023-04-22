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
  static String AUTHOR_NAME = "DSDmark";
  static String AUTHOR_GITHUB_ID = "https://www.github.com/DSDmark";

  // colors
  static final String RESET = "\u001B[0m";
  static final String BLACK = "\u001B[30m";
  static final String RED = "\u001B[31m";
  static final String GREEN = "\u001B[32m";
  static final String MAGENTA = "\u001B[35m";

  // Background colors
  static final String BGC_GREEN = "\u001B[42m";
  static final String BGC_YELLOW = "\u001B[43m";
  static final String BGC_BLUE = "\u001B[44m";
  static final String BGC_MAGENTA = "\u001B[45m";

  // Text styles
  static final String BOLD = "\u001B[1m";
  static final String UNDERLINE = "\u001B[4m";

  // winning conditions  
  static int[][] winnerState = new int[][]{{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

  public final static void printBoard(){

    // clear the console
    System.out.print("\033[H\033[2J"); 
    System.out.flush();

    // creating the game area
    System.out.println(GREEN+"\n         |        |       "+RESET);
    System.out.println(GREEN+"    "+gameArea[0]+"   |   "+gameArea[1]+"   |  "+gameArea[2]+"  "+RESET);
    System.out.println(GREEN+"         |        |        "+RESET);
    System.out.println(GREEN+" --------|--------|--------\t"+BGC_YELLOW+BLACK+UNDERLINE+"CREATE BY "+AUTHOR_NAME+RESET);
    System.out.println(GREEN+"         |        |       "+RESET);
    System.out.println(GREEN+"    "+gameArea[3]+"   |   "+gameArea[4]+"   |  "+gameArea[5]+"  \t"+BGC_BLUE+UNDERLINE+AUTHOR_GITHUB_ID+RESET);
    System.out.println(GREEN+"         |        |       "+RESET);
    System.out.println(GREEN+" --------|--------|--------"+RESET);
    System.out.println(GREEN+"         |        |       "+RESET);
    System.out.println(GREEN+"    "+gameArea[6]+"   |   "+gameArea[7]+"   |  "+gameArea[8]+"  "+RESET);
    System.out.println(GREEN+"         |        |      \n"+RESET);

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
      gameArea[i] = this.spaces; 
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

  private final void checkWinState(){
    
for (int i = 0; i < winnerState.length; i++) {
    int index1 = winnerState[i][0];
    int index2 = winnerState[i][1];
    int index3 = winnerState[i][2];

    if (index1 < 0 || index1 >= gameArea.length ||
        index2 < 0 || index2 >= gameArea.length ||
        index3 < 0 || index3 >= gameArea.length) {
        throw new IndexOutOfBoundsException("Invalid index in winnerState array");
    }

    String a = gameArea[index1];
    String b = gameArea[index2];
    String c = gameArea[index3];

    if (a == spaces || b == spaces || c == spaces) {
        continue;
    }
    if (a == b && b == c) {
        winner = b;
        break;
    }
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

        if(gameArea[x] !=spaces){
          throw new InputMismatchException();
        }else{
          gameArea[x] = mainPlayer;
          autoPlayer();
          printBoard(); 
          checkWinState();
        } 
      } catch(InputMismatchException e){      

        System.out.println(BOLD+BGC_MAGENTA+BLACK+ "\noops..🚯 entered value is not number.."+RESET);
        sc.nextLine();     // consume the non-integer input and clear the Scanner buffer
        
      } catch(ArrayIndexOutOfBoundsException e){

       System.out.println(BOLD+BGC_YELLOW+BLACK+"\n🤠 Hey dude, Enter a valid number"+RESET);
      } 

    }while((gameArea.length != chackIsAreaFull()) && winner.isEmpty()); 
    checkWinner(winner);
  }

  public final void autoPlayer(){
    int x = 0; 
      if(chackIsAreaFull() !=0){
    do{
        x = (int)(Math.random()* (8 - 0)+1);
    }while(gameArea[x] != spaces) ;
    gameArea[x] = computer;
    printBoard();
      }
  }

  public static void main(String[] args) {
    TicTacToe game = new TicTacToe();
    game.initValues();
    game.printBoard();
    game.getInput();
  }
}

