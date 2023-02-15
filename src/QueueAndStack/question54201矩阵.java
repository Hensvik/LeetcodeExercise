package QueueAndStack;

//给定一个由 0 和 1 组成的矩阵 mat，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
//
//两个相邻元素间的距离为 1 。
//
//示例 1：
//
//输入：mat = [[0,0,0],[0,1,0],[0,0,0]]
//输出：[[0,0,0],[0,1,0],[0,0,0]]
//示例 2：
//
//输入：mat = [[0,0,0],[0,1,0],[1,1,1]]
//输出：[[0,0,0],[0,1,0],[1,2,1]]
//
//提示：
//
//m == mat.length
//n == mat[i].length
//1 <= m, n <= 104
//1 <= m * n <= 104
//mat[i][j] is either 0 or 1.
//mat 中至少有一个 0

public class question54201矩阵 {
    public static int[][] updateMatrix(int[][] mat) {
        int[][] res = new int[mat.length][mat[0].length];
        /*for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                res[i][j] = Integer.MAX_VALUE;
            }
        }*/

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                res[i][j] = dfs(mat,i,j,res,0);
            }
        }

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.println(res[i][j]);
            }
        }
        return res;
    }
    public static int dfs(int[][]mat,int i,int j,int[][]res,int count){
        if(i<0 || j<0 || i== mat.length || j==mat[0].length){
            return count;
        }
        dfs(mat,i+1,j,res,count+1);
        dfs(mat,i-1,j,res,count+1);
        dfs(mat,i,j+1,res,count+1);
        dfs(mat,i,j-1,res,count+1);
        return Math.min(res[i][j],count);
    }

    public static void main(String[] args) {
        int [][] mat = {{0,0,0}, {0,1,0},{0,0,0}};
        updateMatrix(mat);
    }
}
