public class numIslands200 {
    public int numIslands(char[][] grid) {
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length;j++ ) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    num++;
                }
            }
        }

        return num;
    }


    public void dfs(char[][] grid, int r, int c) {

        if (r >= grid.length || r < 0 || c < 0 || c >= grid[0].length) {
            return;
        }


        if (grid[r][c] == '0')
            return;
        grid[r][c] = '0';

        dfs(grid, r, c-1);
        dfs(grid, r, c+1);
        dfs(grid, r-1, c);
        dfs(grid, r+1, c);

    }


    public void printgrid(char[][] grid) {
        for (int a = 0; a < grid.length; a++) {
            for (int b = 0; b < grid[0].length;b++ ) {
                System.out.print(grid[a][b] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


}
