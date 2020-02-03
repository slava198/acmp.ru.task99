//import java.util.ArrayList;
//import java.util.Collections;
//
//public class Maze {
//    int hSize;
//    int mSize;
//    int nSize;
//    char[][][] charMaze;
//    short[][][] intMaze;
//    int startI;
//    int startJ;
//    int startK;
//    int finishI;
//    int finishJ;
//    int finishK;
//
//
//    public Maze(int hSize, int mSize, int nSize, char[][][] charMaze, short[][][] intMaze,
//                int startI, int startJ, int startK, int finishI, int finishJ, int finishK) {
//        this.hSize = hSize;
//        this.mSize = mSize;
//        this.nSize = nSize;
//        this.charMaze = charMaze;
//        this.intMaze = intMaze;
//        this.startI = startI;
//        this.startJ = startJ;
//        this.startK = startK;
//        this.finishI = finishI;
//        this.finishJ = finishJ;
//        this.finishK = finishK;
//    }
//
//
//    public void markNeighbours(int i, int j, int k) {
//        int self = intMaze[i][j][k];
//        if (i < hSize - 1 && charMaze[i + 1][j][k] == '.' && (intMaze[i + 1][j][k] - self > 1 || intMaze[i + 1][j][k] == 0)) {
//            intMaze[i + 1][j][k] = (short) (intMaze[i][j][k] + 1);
//            markNeighbours(i + 1, j, k);
//        }
//        if (j > 0 && charMaze[i][j - 1][k] == '.' && (intMaze[i][j - 1][k] - self > 1 || intMaze[i][j - 1][k] == 0)) {
//            intMaze[i][j - 1][k] = (short) (intMaze[i][j][k] + 1);
//            markNeighbours(i, j - 1, k);
//        }
//        if (j < mSize - 1 && charMaze[i][j + 1][k] == '.' && (intMaze[i][j + 1][k] - self > 1 || intMaze[i][j + 1][k] == 0)) {
//            intMaze[i][j + 1][k] = (short) (intMaze[i][j][k] + 1);
//            markNeighbours(i, j + 1, k);
//        }
//        if (k > 0 && charMaze[i][j][k - 1] == '.' && (intMaze[i][j][k - 1] - self > 1 || intMaze[i][j][k - 1] == 0)) {
//            intMaze[i][j][k - 1] = (short) (intMaze[i][j][k] + 1);
//            markNeighbours(i, j, k - 1);
//        }
//        if (k < nSize - 1 && charMaze[i][j][k + 1] == '.' && (intMaze[i][j][k + 1] - self > 1 || intMaze[i][j][k + 1] == 0)) {
//            intMaze[i][j][k + 1] = (short) (intMaze[i][j][k] + 1);
//            markNeighbours(i, j, k + 1);
//        }
//    }
//
//
//    public int getBestTime() {
//        ArrayList<Integer> neighbourTimes = new ArrayList<>();
//
//        if (finishI > 0 && intMaze[finishI - 1][finishJ][finishK] != 0) {
//            neighbourTimes.add((int) intMaze[finishI - 1][finishJ][finishK]);
//        }
//        if (finishJ > 0 && intMaze[finishI][finishJ - 1][finishK] != 0) {
//            neighbourTimes.add((int) intMaze[finishI][finishJ - 1][finishK]);
//        }
//        if (finishJ < mSize - 1 && intMaze[finishI][finishJ + 1][finishK] != 0) {
//            neighbourTimes.add((int) intMaze[finishI][finishJ + 1][finishK]);
//        }
//        if (finishK > 0 && intMaze[finishI][finishJ][finishK - 1] != 0) {
//            neighbourTimes.add((int) intMaze[finishI][finishJ][finishK - 1]);
//        }
//        if (finishK < nSize - 1 && intMaze[finishI][finishJ][finishK + 1] != 0) {
//            neighbourTimes.add((int) intMaze[finishI][finishJ][finishK + 1]);
//        }
//
//        return (Collections.min(neighbourTimes) + 1) * 5;
//    }
//
//
//}
