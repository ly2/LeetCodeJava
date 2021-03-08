public class tictactoe1275 {


    public String tictactoe(int[][] moves) {
        int[] grid = new int[9];
        int len = moves.length;
        if(len < 5)
            return "Pending";

        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) {
                grid[moves[i][0]*3+moves[i][1]] = 1;
            } else {
                grid[moves[i][0]*3+moves[i][1]] = 2;
            }
        }
        int row = moves[len-1][0]*3;
        int col = moves[len-1][1];
        int ans = check(grid, row, col);

        if (ans == 1)
            return "A";
        else if (ans == 2)
            return "B";

        if (len < 9)
            return "Pending";
        return "Draw";
    }

    public int check(int[] grid, int row, int col) {
        if (grid[row]== grid[row+1] && grid[row] == grid[row+2])
            return grid[row];
        if (grid[col] == grid[col+3] && grid[col] == grid[col+6])
            return grid[col];
        if ((row+col)%2 == 0) {
            if (grid[0]==grid[4]&& grid[0]==grid[8] )
                return grid[4];
            if ( grid[2]==grid[4]&& grid[4] == grid[6])
                return grid[4];
        }
        return 0;
    }



    // submission method
    public String tictactoe2(int[][] moves) {
        int[] aRow = new int[3], aCol = new int[3], bRow = new int[3], bCol = new int[3];
        int  aD1 = 0, aD2 = 0, bD1 = 0, bD2 = 0;
        for (int i = 0; i < moves.length; ++i) {
            int r = moves[i][0], c = moves[i][1];
            if (i % 2 == 1) {
                if (++bRow[r] == 3 || ++bCol[c] == 3 || r == c && ++bD1 == 3 || r + c == 2 && ++bD2 == 3) return "B";
            }else {
                if (++aRow[r] == 3 || ++aCol[c] == 3 || r == c && ++aD1 == 3 || r + c == 2 && ++aD2 == 3) return "A";
            }
        }
        return moves.length == 9 ? "Draw" : "Pending";
    }
}
