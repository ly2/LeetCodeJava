
public class exist79 {

    //7 ms	40.8 MB
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                visited[i][j] =true;
                if (subexist(board, word, i,j,visited))
                    return true;
                visited[i][j] =false;
            }
        }


        return false;
    }

    public boolean subexist(char[][] board, String word, int row, int col,boolean[][] visited) {

        char cur = word.charAt(0);
        if (board[row][col] != cur)
            return false;

        word = word.substring(1);
        if (word.isEmpty())
            return true;


        if (row-1 >= 0 && !visited[row-1][col]) {
            visited[row-1][col] = true;
            if (subexist(board, word, row-1,col, visited))
                return true;
            visited[row-1][col] = false;
        }
        if (row+1 < board.length && !visited[row+1][col]) {
            visited[row+1][col] = true;
            if (subexist(board, word, row + 1, col, visited))
                return true;
            visited[row+1][col] = false;
        }
        if (col-1 >= 0 && !visited[row][col-1]) {
            visited[row][col-1] = true;
            if (subexist(board, word, row,col-1, visited))
                return true;
            visited[row][col-1] = false;
        }
        if (col+1 < board[0].length&& !visited[row][col+1]) {
            visited[row][col+1] = true;
            if (subexist(board, word, row , col+1, visited))
                return true;
            visited[row][col+1] = false;
        }

        return false;

    }


    // better method  5 ms	41 MB
    public boolean exist2(char[][] board, String word) {
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[0].length; j++)
                if(board[i][j] == word.charAt(0) && isFound(board, i, j, word, 0))
                    return true;

        return false;
    }

    private boolean isFound(char[][] board, int i, int j, String word, int index) {
        if(index == word.length()) return true;
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length) return false;
        if(word.charAt(index) != board[i][j]) return false;
        char temp = board[i][j];
        board[i][j] = '*';
        if(isFound(board, i + 1, j, word, index + 1) ||
                isFound(board, i - 1, j, word, index + 1) ||
                isFound(board, i, j + 1, word, index + 1) ||
                isFound(board, i, j - 1, word, index + 1))
            return true;
        board[i][j] = temp;
        return false;
    }

}
