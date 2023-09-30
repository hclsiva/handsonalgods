package leetcode.cheatsheet;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for(int i = 0; i < m;i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j ==0){
                    dp[i][j] = 1;
                } else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        print(dp);
        return dp[m-1][n-1];
    }
    private void print(int[][] e){
        for(int i = 0; i < e.length; i++){
            for(int j = 0;j < e[0].length; j++){
                System.out.print(e[i][j] +" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.uniquePaths(3,4));
    }
}
