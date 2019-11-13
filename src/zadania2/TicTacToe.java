package zadania2;

import java.util.Scanner;

public class TicTacToe {
    static char[][] gameBoard = new char[3][3];

    public static void main(String[] args) {
        char cross = 'X';
        char circle = 'O';
        System.out.println("Hello this is Tic Tac Toe game!");
        System.out.println("First player has X, second has O");


        int round = 0;
        char currentSign;
        boolean isNobodyWin = true;
        do {
            showBoard();
            System.out.println();
            System.out.println("Round " + round);
            if (round % 2 == 0) {
                currentSign = cross;
                makeMove(currentSign);
            } else {
                currentSign = circle;
                makeMove(currentSign);
            }
            round++;
        } while(round < 9 && (isNobodyWin = !isWin(currentSign)));

        if (round == 9 && isNobodyWin) {
            System.out.println("Draw!!!");
        }
    }

    private static boolean isWin(char currentSign) {
        int rowCounter;
        int columnCounter;
        int leftDiagonal = 0; //deklarujemy tutaj aby nie zerować po wewnętrznym forze
        int rightDiagonal = 0;
        boolean isWin = false;
        for (int row = 0; row < gameBoard.length; row++) {
            rowCounter = 0;
            columnCounter = 0;
            for (int column = 0; column < gameBoard[row].length; column++) {
                if (gameBoard[row][column] == currentSign) {
                    rowCounter++;
                }

                if (gameBoard[column][row] == currentSign) {
                    columnCounter++;
                }

                if (row == column && gameBoard[row][column] == currentSign) {
                    leftDiagonal++;
                }

                if (row + column == gameBoard.length - 1 && gameBoard[row][column] == currentSign) {
                    rightDiagonal++;
                }
            }
            if (rowCounter == gameBoard.length || columnCounter == gameBoard.length) {
                isWin = true;
            }
        }
        if (leftDiagonal == gameBoard.length || rightDiagonal == gameBoard.length) { //tutaj sprawdzamy bo dopiero po przejściu po całej tablicy ma to sens
            isWin = true;
            System.out.println(currentSign + " is win!!!");
            showBoard();
        }
        return isWin;
    }

    public static void showBoard() {
        for (int row = 0; row < gameBoard.length; row++) {
            for (int column = 0; column < gameBoard[row].length; column++) {
                if (gameBoard[row][column] == 0) {
                    System.out.print("| |");
                } else {
                    System.out.print("|" + gameBoard[row][column] + "|");
                }
            }
            System.out.println();
            System.out.println("---------");
        }
    }

    public static void makeMove(char sign) {
        System.out.println(sign + " Youre turn has come!");
        Scanner input = new Scanner(System.in);
        int row;
        int column;
        do {
            System.out.println("Type cords:");
            row = input.nextInt();
            column = input.nextInt();
        } while (isTaken(row, column));

        gameBoard[row][column] = sign;
    }

    public static boolean isTaken(int row, int column) {
        return gameBoard[row][column] != 0;
    }

}
