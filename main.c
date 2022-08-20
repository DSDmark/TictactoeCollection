// usr/bin/clang "$0" && exec ./a.out "$@"
#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <time.h>
#include <string.h>

//* Font code colours
#define GRN "\x1B[32m"
#define YEL "\x1B[33m"
#define BLU "\x1B[34m"
#define CYN "\x1B[36m"

//* back ground code colours
#define gRED "\x1B[41m"

//* TYPOGRAPHY
#define Strikethrough "\x1B[9m"
#define Underlined "\x1B[4m"
#define BOLD "\x1B[1m"

//* reset foreground and background to normal colours
#define RESET "\x1B[0m"

// TODO ALL MAIN VARIBLES
char *gameArea[9];
char *mainPlayer = "❌\t";
char *computer = "⚪\t";
char *checkSpace = "\t";

char *winner;
int winState[9][3] = {
    {0, 1, 2},
    {3, 4, 5},
    {6, 7, 8},
    {0, 3, 6},
    {1, 4, 7},
    {2, 5, 8},
    {0, 4, 8},
    {2, 4, 6}
};

//! ALL MAIN FUNCTIONS SEE DOWN BELOW
void drew(void);
int checkField(void);
void resetArea(void);
void checkWinner(char *);
void userInput(void);
void autoPlayer(void);
void validate();

char *winner;
int main()
{
   validate();
}


//! IMPORTANT FUNCTION
void validate()
{
    winner = "\0";
    resetArea();
    do
    {
        drew();
        userInput();
        autoPlayer();
        
        for (int i = 0; i < 9; i++)
        {
            printf("%d,%s,%s,%s",i,gameArea[winState[i][0]],gameArea[winState[i][1]],gameArea[winState[i][2]]);
            if (gameArea[winState[i][0]] == mainPlayer & gameArea[winState[i][1]] == mainPlayer & gameArea[winState[i][2]] == mainPlayer)
            {
                winner = mainPlayer;
             
            break;
                           }
          else if (gameArea[winState[i][0]] == computer && gameArea[winState[i][1]] == computer && gameArea[winState[i][2]] == computer)
            {
                winner = computer;
                break;
                
            }else{
                winner = " ";
            }
        }
        {
        }
        drew();
        if((checkField() == 0) && (winner = " ")) break;
    } while (winner == " " || checkField() == 0);
    checkWinner(winner);
}

//? DREWING THE LINES
void drew()
{
    //system("clear");
    printf(GRN BOLD "\n\t|\t|\t" RESET);
    printf(GRN BOLD "\n  %s|  %s|   %s" RESET, gameArea[0], gameArea[1], gameArea[2]);
    printf(GRN BOLD "\n--------|-------|-------" RESET Underlined BOLD "\t\e[1;98mwww.github.com/DSDmark" RESET);
    printf(GRN BOLD "\n\t|\t|\t" RESET);
    printf(GRN BOLD "\n  %s|  %s|  %s" RESET  BOLD "\t\e[7;77m\e[1;92m\e[5;77mUnder The work:)" RESET, gameArea[3], gameArea[4], gameArea[5]);
    printf(GRN BOLD "\n--------|-------|-------" RESET);
    printf(GRN BOLD "\n\t|\t|\t" RESET);
    printf(GRN BOLD "\n  %s|  %s|  %s\n\n" RESET, gameArea[6], gameArea[7], gameArea[8]);
}

//? RESET THE AREA FOR NEW GAME
void resetArea()
{
    int i;
    for (i = 0; i <= 9; i++)
        gameArea[i] = checkSpace;
}

//? CHECK ALL field FILLED OR NOT
int checkField()
{
    int field = 9;
    int i;
    for (i = 0; i < 9; i++)
    {
        if (gameArea[i] != checkSpace)
        {
            field--;
        }
    }
    return field;
}

//? CHECK THE WINNER
void checkWinner(char *winner)
{
    if (winner == mainPlayer)
    {
        printf(YEL Underlined BOLD "👑 Hey, Nice plyed you win\n\n" RESET);
    }
    else if (winner == computer)
    {
        printf(gRED Underlined BOLD "😝 So sad,Try next time \n\n" RESET);
    }
    else
    {
        printf(CYN Underlined BOLD "😞 It's a Tie!, What a shame\n\n" RESET);
    }
}

//? TAKE INPUT FROM USER
void userInput()
{
    int x;
    do
    {
        printf(BLU BOLD Underlined "What your lucky N0.#(1-9)❔:" RESET);
        scanf("%d", &x);
        x--;

        // TODO VALIDET THE INPUT FIELD
        if (0 >= x)
        {
            printf(Strikethrough gRED GRN "\n🤠 Hey boy, Enter a valid input ❕" RESET);
        }

        //* SAVE THE INPUT
        if (gameArea[x] != checkSpace)
        {
            printf(BOLD Underlined YEL "\nOopps..🚯 Wrong move bro..\n" RESET);
        }
        else
        {
            gameArea[x] = mainPlayer;
            x = '\0';
            break;
        }
    } while (gameArea[x] != checkSpace);
}

//? AUTO PLAYER FOR 0								
void autoPlayer()
{
    int x, y;
    srand(time(0));

    if (checkField() > 0)
    {
        do
        {
            x = (rand() % 8) + 1;
        } while (gameArea[x] != checkSpace);
        gameArea[x] = computer;
        drew();
    }
}
