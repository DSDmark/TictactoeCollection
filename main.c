
#include <ctype.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

//* Font code colours
#define GRN "\x1B[32m"
#define YEL "\x1B[33m"
#define BLU "\x1B[34m"
#define CYN "\x1B[36m"

//* TYPOGRAPHY
#define Strikethrough "\x1B[9m"
#define Underlined "\x1B[4m"
#define BOLD "\x1B[1m"

//* reset foreground and background to normal colours
#define RESET "\x1B[0m"

// TODO ALL MAIN VARIABLES
char gameArea[9][10];
char mainPlayer[] = "❌\t";
char computer[] = "⚪\t";
char checkSpace[] = "\t";
char winner[] = " ";
int winState[8][3] = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6},
                      {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

//! ALL MAIN FUNCTIONS SEE DOWN BELOW
void drew(void);
int checkField(void);
void resetArea(void);
void checkWinner(char *);
void userInput(void);
void autoPlayer(void);
void validate();

int main() { validate(); }

// ! IMPORTANT FUNCTION
void validate() {
  resetArea();
  do {
    drew();
    userInput();
    autoPlayer();

    for (int i = 0; i < 8; i++) {
      if ((strcmp(gameArea[winState[i][0]], mainPlayer) == 0) &&
          (strcmp(gameArea[winState[i][1]], mainPlayer) == 0) &&
          (strcmp(gameArea[winState[i][2]], mainPlayer) == 0)) {
        strcpy(winner, mainPlayer);
        break;
      } else if (strcmp(gameArea[winState[i][0]], computer) == 0 &&
                 strcmp(gameArea[winState[i][1]], computer) == 0 &&
                 strcmp(gameArea[winState[i][2]], computer) == 0) {
        strcpy(winner, computer);
        break;
      } else {
        strcpy(winner, " ");
      }
    }

    if (checkField() == 0 || strcmp(winner, " ") != 0) {
      drew();
      break;
    }
  } while (strcmp(winner, " ") == 0 || checkField() != 0);
  checkWinner(winner);
}

//? DRAWING THE LINES
void drew() {
  system("clear");
  printf(GRN BOLD " \n \t|\t|\t" RESET);
  printf(GRN BOLD "\n %s|  %s|  %s" RESET, gameArea[0], gameArea[1],
         gameArea[2]);
  printf(GRN BOLD "\n--------|-------|-------" RESET Underlined BOLD
                  "\t\e[1;98m https://www.github.com/DSDmark" RESET);
  printf(GRN BOLD "\n\t|\t|\t" RESET);
  printf(GRN BOLD "\n  %s|  %s|  %s" RESET BOLD
                  "\t\e[7;77m\e[1;92m\e[5;77m Developer by DSDmark :-)" RESET,
         gameArea[3], gameArea[4], gameArea[5]);
  printf(GRN BOLD "\n--------|-------|-------" RESET);
  printf(GRN BOLD "\n\t|\t|\t" RESET);
  printf(GRN BOLD "\n  %s|  %s|  %s\n\n" RESET, gameArea[6], gameArea[7],
         gameArea[8]);
}

// ? RESET THE AREA FOR NEW GAME
void resetArea() {
  int i;
  strcpy(winner, " ");
  for (i = 0; i < 9; i++) {
    strcpy(gameArea[i], checkSpace);
  }
}

//? CHECK ALL field FILLED OR NOT
int checkField() {
  int field = 9;
  int i;
  for (i = 0; i < 9; i++) {
    if (strcmp(gameArea[i], checkSpace) != 0) {
      field--;
    }
  }
  return field;
}

//? CHECK THE WINNER
void checkWinner(char *winner) {
  if (strcmp(winner, mainPlayer) == 0) {
    printf(YEL Underlined BOLD "👑 Hey, Nice played you win\n\n" RESET);
  } else if (strcmp(winner, computer) == 0) {
    printf(BLU Underlined BOLD "😝 So sad,Try next time \n\n" RESET);
  } else {
    printf(CYN Underlined BOLD "😞 It's a Tie!, What a shame\n\n" RESET);
  }
}

// ? TAKE INPUT FROM USER
void userInput() {
  int x;
  do {
    printf(BLU BOLD Underlined "What your Lucky N0.#(1-9)❔:" RESET);
    scanf("%d", &x);
    x--;

    // TODO VALIDATE THE INPUT FIELD
    if (0 > x) {
      printf(Strikethrough GRN "\n🤠 Hey dude, Enter a valid input ❕" RESET);
    }

    //* SAVE THE INPUT
    if (strcmp(gameArea[x], checkSpace) != 0) {
      printf(BOLD Underlined YEL "\nOops..🚯 Wrong move bro..\n" RESET);
    } else {
      strcpy(gameArea[x], mainPlayer);
      x = '\0';
      break;
    }

  } while (strcmp(gameArea[x], checkSpace) != 0);
}

//? AUTO PLAYER FOR 0
void autoPlayer() {
  int x;
  srand(time(0));
  if (checkField() > 0) {
    do {
      x = (rand() % 8) + 1;
    } while (strcmp(gameArea[x], checkSpace) != 0);
    strcpy(gameArea[x], computer);
    drew();
  }
}
