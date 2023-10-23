package leetcode.cheatsheet;

public class FindIslands {
    public int numIslands(char[] [] grid){
        int count = 0;
        print(grid);
        for(int i = 0; i < grid.length;i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    count++;
                    cancelIsLand(grid,i,j);
                }
            }
        }
        System.out.println();
        print(grid);
        return count;

    }
    private void cancelIsLand(char [][] grid, int i, int j){
        if (i<0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        cancelIsLand(grid,i-1,j);
        cancelIsLand(grid,i+1,j);
        cancelIsLand(grid,i,j-1);
        cancelIsLand(grid,i,j+1);
    }
    private void print(char[][] grid){
        for(int i = 0; i < grid.length;i++){
            for(int j = 0; j < grid[0].length; j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        FindIslands islands = new FindIslands();
        char[][] grid = new char[][] {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'},
        };
        System.out.println(islands.numIslands(grid));
        grid = new char[][] {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'},
        };
        System.out.println(islands.numIslands(grid));
    }
}
