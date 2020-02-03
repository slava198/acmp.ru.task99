import java.io.*;
import java.util.Scanner;

public class Task99 {

    public static void main(String[] args) throws IOException {

        // parsing file
        Scanner scanner = new Scanner(new File("INPUT.TXT"));
        int h = scanner.nextInt();
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        char[][][] mazeChar = new char[h][m][n];
        int[][][] mazeInt = new int[h][m][n];
        int startI = 0;
        int startJ = 0;
        int startK = 0;
        int finishI = 0;
        int finishJ = 0;
        int finishK = 0;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < m; j++) {
                String mazeRow = scanner.next();
                for (int k = 0; k < n; k++) {
                    mazeChar[i][j][k] = mazeRow.charAt(k);
                    if (mazeChar[i][j][k] == '1') {
                        startI = i;
                        startJ = j;
                        startK = k;
                    }
                    if (mazeChar[i][j][k] == '2') {
                        finishI = i;
                        finishJ = j;
                        finishK = k;
                        mazeChar[i][j][k] = '.';
                    }
                }
            }
        }
        scanner.close();

        // working with data
        Maze maze = new Maze(h, m, n, mazeChar, mazeInt, startI, startJ, startK, finishI, finishJ, finishK);
        maze.markNeighbours(startI, startJ, startK);
        maze.optimize();

        // writing result
        FileWriter fileWriter = new FileWriter("OUTPUT.TXT");
        long result = mazeInt[finishI][finishJ][finishK] * 5;
        fileWriter.write(String.valueOf(result));
        fileWriter.close();
    }


    public static class Maze {
        int hSize;
        int mSize;
        int nSize;
        char[][][] charMaze;
        int[][][] intMaze;
        int startI;
        int startJ;
        int startK;
        int finishI;
        int finishJ;
        int finishK;


        public Maze(int hSize, int mSize, int nSize, char[][][] charMaze, int[][][] intMaze,
                    int startI, int startJ, int startK, int finishI, int finishJ, int finishK) {
            this.hSize = hSize;
            this.mSize = mSize;
            this.nSize = nSize;
            this.charMaze = charMaze;
            this.intMaze = intMaze;
            this.startI = startI;
            this.startJ = startJ;
            this.startK = startK;
            this.finishI = finishI;
            this.finishJ = finishJ;
            this.finishK = finishK;
        }


        public void markNeighbours(int i, int j, int k) {
            int self = intMaze[i][j][k];
            //down neighbour test
            if (i < hSize - 1 && charMaze[i + 1][j][k] == '.' && (intMaze[i + 1][j][k] - self > 1 || intMaze[i + 1][j][k] == 0)) {
                intMaze[i + 1][j][k] =  (intMaze[i][j][k] + 1);
                markNeighbours(i + 1, j, k);
            }
            //south neighbour test
            if (j > 0 && charMaze[i][j - 1][k] == '.' && (intMaze[i][j - 1][k] - self > 1 || intMaze[i][j - 1][k] == 0)) {
                intMaze[i][j - 1][k] =  (intMaze[i][j][k] + 1);
                markNeighbours(i, j - 1, k);
            }
            //north neighbour test
            if (j < mSize - 1 && charMaze[i][j + 1][k] == '.' && (intMaze[i][j + 1][k] - self > 1 || intMaze[i][j + 1][k] == 0)) {
                intMaze[i][j + 1][k] =  (intMaze[i][j][k] + 1);
                markNeighbours(i, j + 1, k);
            }
            //west neighbour test
            if (k > 0 && charMaze[i][j][k - 1] == '.' && (intMaze[i][j][k - 1] - self > 1 || intMaze[i][j][k - 1] == 0)) {
                intMaze[i][j][k - 1] =  (intMaze[i][j][k] + 1);
                markNeighbours(i, j, k - 1);
            }
            //east neighbour test
            if (k < nSize - 1 && charMaze[i][j][k + 1] == '.' && (intMaze[i][j][k + 1] - self > 1 || intMaze[i][j][k + 1] == 0)) {
                intMaze[i][j][k + 1] =  (intMaze[i][j][k] + 1);
                markNeighbours(i, j, k + 1);
            }
        }

        public void optimize() {
            for (int i = 0; i < hSize; i++) {
                for (int j = 0; j < mSize; j++) {
                    for (int k = 0; k < nSize; k++) {
                        if (intMaze[i][j][k] != 0) {
                            markNeighbours(i, j, k);
                        }
                    }
                }
            }
        }

    }
}




