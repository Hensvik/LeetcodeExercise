package medium;

//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
//
//机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
//
//现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
//
//网格中的障碍物和空位置分别用 1 和 0 来表示。
//
// 
//
//示例 1：
//
//
//输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
//输出：2
//解释：3x3 网格的正中间有一个障碍物。
//从左上角到右下角一共有 2 条不同的路径：
//1. 向右 -> 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右 -> 向右
//示例 2：
//
//
//输入：obstacleGrid = [[0,1],[0,0]]
//输出：1
// 
//
//提示：
//
//m == obstacleGrid.length
//n == obstacleGrid[i].length
//1 <= m, n <= 100
//obstacleGrid[i][j] 为 0 或 1
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/unique-paths-ii
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

//int[a][b] obstacleGrid 二维数组的初始化，a是行，b是列
public class question63不同路径2 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        /*System.out.println(obstacleGrid.length);
        System.out.println(obstacleGrid[0].length);
        System.out.println(obstacleGrid[3][1]);*/
        if(obstacleGrid.length==0 && obstacleGrid[0].length==0){
            if(obstacleGrid[0][0]==0){
                return 1;
            }else{
                return 0;
            }
        }

        for(int i=0;i<obstacleGrid[0].length;i++){  //0-2
            for(int j=0;j<obstacleGrid.length;j++){ //0-3
                if(obstacleGrid[j][i]==1){
                    obstacleGrid[j][i]=0;
                }else if((i==0 || j==0) && (obstacleGrid.length!=1 || obstacleGrid[0].length!=1)){
                    obstacleGrid[j][i]=-1;
                }else{
                    obstacleGrid[j][i]=obstacleGrid[j-1][i]+obstacleGrid[j][i-1];
                }
            }
        }
        System.out.println(Math.abs(obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1]));
        return Math.abs(obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1]);
    }

    public static void main(String[] args) {
        int[][] obstacleGrid={{0,0,0},{0,1,0},{2,0,0}};
        System.out.println(obstacleGrid[0][2]);
        //uniquePathsWithObstacles(obstacleGrid);
    }
}
