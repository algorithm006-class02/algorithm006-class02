public class LeetCode_64 {


    //暴力
    public static int calculate(int[][] grid,int i,int j){
        if(i==grid.length || j==grid[0].length){
            return  Integer.MAX_VALUE;
        }
        if(i==grid.length-1 && j==grid[0].length-1) return grid[i][j];
        return grid[i][j]+Math.min(calculate(grid,i+1,j),calculate(grid,i,j+1));
    }

    public static int minPathSum(int[][] grid){
        return calculate(grid,0,0);
    }

    //二维动态规划
    public static int minPathSum1(int[][] grid){
        int[][] dp=new int[grid.length][grid[0].length];
        for (int i=grid.length-1;i>=0;i--){
            for(int j=grid[0].length-1;j>=0;j--){
                if(i==grid.length-1 && j!=grid[0].length-1){
                    dp[i][j]=grid[i][j]+dp[i][j+1];
                }else if(j==grid[0].length-1 && i!=grid.length-1)
                    dp[i][j]=grid[i][j]+dp[i+1][j];
                else if(i!=grid.length-1 && j!=grid[0].length-1)
                    dp[i][j]=grid[i][j]+dp[i+1][j+1];
                else
                    dp[i][j]=grid[i][j];
            }
        }
        return dp[0][0];
    }

    public static  void main(String[] args){

        //int data[]={1,1,2};
        int[][] data={{1,3,1},{1,5,1},{4,2,1}};

        //int b=minPathSum(data);
        int b=minPathSum1(data);
        System.out.println("b:"+b);


    }

}
