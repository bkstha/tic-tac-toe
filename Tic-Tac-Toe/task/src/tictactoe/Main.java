package tictactoe;

import java.util.*;

public class Main {
    static Boolean xxx = false;
    static Boolean ooo = false;

    static char[] xo = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
    static int xs = 0;
    static int os = 0;
    static char[][] field = new char[3][3];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // print field and result
        fillUpValues(field);
        printResult(field);

        boolean isX = true;
        while (true) {

            System.out.print("Enter the coordinates: ");
            char[] inputs = sc.nextLine().toCharArray();

            int x = 0, y = 0;
            try {
                x = Integer.parseInt(inputs[0] + "");
                y = Integer.parseInt(inputs[2] + "");

                if (x < 1 || x > 3 || y < 1 || y > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }
            } catch (Exception e) {
                System.out.println("You should enter numbers!");
                continue;
            }
            int xIndex = getXIndex(x);
            int yIndex = getYIndex(y);

            if (field[yIndex][xIndex] == ' ') {
                if (isX) {
                    xs++;
                    field[yIndex][xIndex] = 'X';
                } else {
                    os++;
                    field[yIndex][xIndex] ='O';
                }
                isX = !isX;
                checkValue(field);
                printResult(field);
                String result = getResult(field);
                if (!result.equalsIgnoreCase("game not finished")) {
                    System.out.println(result);
                    break;
                }
            } else {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }
        }
    }

    public static void fillUpValues(char[][] field) {
//         fill up the field, count X's & O's
        for (int i = 0; i < 9; i++) {
            field[i / 3][i % 3] = xo[i];

            if (xo[i] == 'X') {
                xs += 1;
            } else if (xo[i] == 'O') {
                os += 1;
            }
        }

    }

    public static String getResult(char[][] field) {
        return Math.abs(xs - os) > 1 || xxx && ooo ? "Impossible"
                : xxx ? "X wins"
                : ooo ? "O wins"
                : xs + os == 9 ? "Draw"
                : "Game not finished";
    }

    public static void checkValue(char[][] field) {
        // check if row or column or any of diagonals is win for someone
        for (int i = 0; i < 3; i++) {
            int row = 0;
            int clm = 0;
            int mDiag = 0;
            int aDiag = 0;

            for (int j = 0; j < 3; j++) {
                row += field[i][j];
                clm += field[j][i];
                mDiag += field[j][j];
                aDiag += field[j][2 - j];
            }

            // ASCII value for X is 88 (X+X+X is 264)
            // ASCII value for O is 79 (O+O+O is 237)
            xxx = xxx || row == 264 || clm == 264 || mDiag == 264 || aDiag == 264;
            ooo = ooo || row == 237 || clm == 237 || mDiag == 237 || aDiag == 237;
        }
    }

    public static int getXIndex(int number) {
        if (number == 1) {
            return 0;
        } else if (number == 2) {
            return 1;
        } else return 2;
    }

    public static int getYIndex(int number) {
        if (number == 1) {
            return 2;
        } else if (number == 2) {
            return 1;
        } else return 0;
    }

    public static void printResult(char[][] field) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.println(String.format("| %s %s %s |", field[i][0], field[i][1], field[i][2]));
        }
        System.out.println("---------");
    }
}