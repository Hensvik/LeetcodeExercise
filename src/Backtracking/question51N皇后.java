package Backtracking;

//按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
//n皇后问题 研究的是如何将 n个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//给你一个整数 n ，返回所有不同的n皇后问题 的解决方案。
//
//每一种解法包含一个不同的n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
//
//示例 1：
//
//
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
//示例 2：
//
//输入：n = 1
//输出：[["Q"]]
//
//提示：
//
//1 <= n <= 9

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class question51N皇后 {
    List<List<String>> res=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        //先将棋盘全部置为.
        for (char[] c:chessboard) {
            Arrays.fill(c,'.');
        }
        backTrack(n,0,chessboard);
        return res;
    }

    public void backTrack(int n,int row,char[][] chessboard){
        //如果已经遍历到了最后一行
        if(row == n){
            res.add(Array2List(chessboard));
            return;
        }

        for (int col = 0; col < n; col++) {
            //校验是否有效
            if(isValid(row,col,n,chessboard)){
                //有效的话，将遍历到的值设置为Q，然后继续遍历下一行，否则的话回滚相关
                chessboard[row][col]='Q';
                backTrack(n,row+1,chessboard);
                chessboard[row][col]='.';
            }
        }
    }

    //将遍历后的棋盘修改回集合类型
    public List Array2List(char[][] chessboard) {
        List<String> list = new ArrayList<>();

        for (char[] c : chessboard) {
            list.add(String.copyValueOf(c));
        }
        return list;
    }

    public boolean isValid(int row, int col, int n, char[][] chessboard) {
        // 检查列
        for (int i=0; i<row; ++i) { // 相当于剪枝
            //如果在某一列也存在Q
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }

        // 检查45度对角线
        for (int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }

        // 检查135度对角线
        for (int i=row-1, j=col+1; i>=0 && j<=n-1; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

}
