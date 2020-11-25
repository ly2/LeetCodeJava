import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class orangesRotting994 {

    int min = 0;
    public int orangesRotting(int[][] grid) {
        ArrayList<Pair<Integer, Integer>> rotten = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length;j++ ) {
                if (grid[i][j] == 2 ) {
                    rotten.add(new Pair(i,j));
                }
            }
        }

        bfs(grid,rotten);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length;j++ ) {
                if (grid[i][j] == 1 ) {
                    return -1;
                }
            }
        }
        return min == 0? 0: min-1;
    }


    public void bfs(int[][] grid, ArrayList<Pair<Integer, Integer>> rotten) {

        if (rotten.isEmpty())
            return;



        min++;
        ArrayList<Pair<Integer, Integer>> newrotten = new ArrayList<>();
        for (Pair<Integer, Integer> p: rotten) {
            int r =  p.getKey();
            int c =  p.getValue();
            System.out.print(r+" "+c+" | ");

            if (r-1 >= 0 && grid[r-1][c] == 1) {
                grid[r-1][c] = 2;
                newrotten.add(new Pair(r - 1, c));
            }
            if (r+1 < grid.length && grid[r+1][c] == 1) {
                grid[r+1][c] = 2;
                newrotten.add(new Pair(r + 1, c));
            }

            if (c-1 >= 0 && grid[r][c-1] == 1) {
                grid[r][c-1] =2;
                newrotten.add(new Pair(r, c - 1));
            }
            if (c+1 < grid[0].length && grid[r][c+1] == 1) {
                grid[r][c+1] = 2;
                newrotten.add(new Pair(r, c + 1));
            }
        }
        System.out.println();
        if (newrotten.isEmpty())
            return;
        bfs(grid, newrotten);
    }





    public int orangesRotting2(int[][] grid) {

        // int[][] stateTracker = new int[grid.length][grid[0].length];

        for(int i = 0; i < grid.length; i++){
            for(int j =0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    rot(i, j, grid, 5);
                }else if(grid[i][j] == 1){
                    grid[i][j] = -1;
                }
            }
        }

        int minMinutes = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j =0; j < grid[0].length; j++){
                if(grid[i][j] == -1 )
                    return -1;
                if(grid[i][j] > minMinutes){
                    minMinutes = grid[i][j];
                }
            }
        }

        return minMinutes == 0? 0 : minMinutes-5;

    }

    private void  rot(int i,int j,int[][] grid, int minMinutes){
        if(i < 0 || i == grid.length || j < 0 || j == grid[0].length)
            return;

        if(grid[i][j] == 0 ||grid[i][j] == -2|| (grid[i][j] >= 5 && grid[i][j] <= minMinutes)) {
            return;
        }

        // System.out.println("i "+i+ " j "+j +" minMinutes "+minMinutes +" "+grid[i][j]);
        if(grid[i][j] == 2){
            grid[i][j] =-2;
            minMinutes = 5;
        }else{
            grid[i][j] = minMinutes;
        }


        rot(i+1, j, grid, minMinutes+1);
        rot(i-1, j, grid, minMinutes+1);
        rot(i, j+1, grid, minMinutes+1);
        rot(i, j-1, grid, minMinutes+1);
    }

//----------------------------------------------------------------------------------------------------

    public int orangesRotting3(int[][] grid) {
        Queue<int[]> bfs = new LinkedList<>();
        int numFresh = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1)
                    numFresh++;
                else if(grid[i][j] == 2)
                    bfs.add(new int[]{i, j});
            }
        }
        if(numFresh == 0)
            return 0;
        int level = 1;
        while(!bfs.isEmpty()){
            int size = bfs.size();
            for(int i=0; i<size; i++){
                int[] curr = bfs.poll();
                if(curr[0] > 0 && grid[curr[0]-1][curr[1]] == 1){
                    numFresh--;
                    grid[curr[0]-1][curr[1]] = 2;
                    bfs.add(new int[]{curr[0]-1, curr[1]});
                }
                if(curr[1] > 0 && grid[curr[0]][curr[1]-1] == 1){
                    numFresh--;
                    grid[curr[0]][curr[1]-1] = 2;
                    bfs.add(new int[]{curr[0], curr[1]-1});
                }
                if(curr[0] < grid.length-1 && grid[curr[0]+1][curr[1]] == 1){
                    numFresh--;
                    grid[curr[0]+1][curr[1]] = 2;
                    bfs.add(new int[]{curr[0]+1, curr[1]});
                }
                if(curr[1] < grid[0].length-1 && grid[curr[0]][curr[1]+1] == 1){
                    numFresh--;
                    grid[curr[0]][curr[1]+1] = 2;
                    bfs.add(new int[]{curr[0], curr[1]+1});
                }
                if(numFresh == 0)
                    return level;
            }
            level++;
        }
        return -1;
    }


}
