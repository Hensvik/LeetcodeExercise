package medium;

//给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
//
// 
//
//示例 1：
//
//
//输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
//输出：[[1,0,1],[0,0,0],[1,0,1]]
//示例 2：
//
//
//输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
//输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
// 
//
//提示：
//
//m == matrix.length
//n == matrix[0].length
//1 <= m, n <= 200
//-231 <= matrix[i][j] <= 231 - 1
// 
//
//进阶：
//
//一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
//一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
//你能想出一个仅使用常量空间的解决方案吗？
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/set-matrix-zeroes
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class question73矩阵置零 {
    public static void setZeroes(int[][] matrix) {
        int temp;
        //int[][]count=new int[matrix.length][matrix[0].length];
        int []rows = new int[matrix.length];
        int []cols = new int[matrix[0].length];

        for(int i=0;i< matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                temp = matrix[i][j];
                if(temp==0){
                    rows[i]=1;
                    cols[j]=1;
                }
            }
        }

        for(int k=0;k<rows.length;k++){
            for(int l=0;k<cols.length;l++){
                if(rows[k]==1||cols[l]==1){
                    matrix[k][l]=0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int [][]matrix = {{1,1,1},{1,0,1},{1,1,1}};
        setZeroes(matrix);
    }

}
