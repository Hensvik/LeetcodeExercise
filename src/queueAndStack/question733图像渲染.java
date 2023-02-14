package queueAndStack;

//有一幅以m x n的二维整数数组表示的图画image，其中image[i][j]表示该图画的像素值大小。
//
//你也被给予三个整数 sr , sc 和 newColor 。你应该从像素image[sr][sc]开始对图像进行 上色填充 。
//
//为了完成 上色工作 ，从初始像素开始，记录初始坐标的 上下左右四个方向上 像素值与初始坐标相同的相连像素点，接着再记录这四个方向上符合条件的像素点与他们对应 四个方向上 像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为 newColor 。
//
//最后返回 经过上色渲染后的图像。
//
//
//示例 1:
//
//输入: image = [[1,1,1],[1,1,0],[1,0,1]]，sr = 1, sc = 1, newColor = 2
//输出: [[2,2,2],[2,2,0],[2,0,1]]
//解析: 在图像的正中间，(坐标(sr,sc)=(1,1)),在路径上所有符合条件的像素点的颜色都被更改成2。
//注意，右下角的像素没有更改为2，因为它不是在上下左右四个方向上与初始点相连的像素点。
//示例 2:
//
//输入: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, newColor = 2
//输出: [[2,2,2],[2,2,2]]
//
//提示:
//
//m == image.length
//n == image[i].length
//1 <= m, n <= 50
//0 <= image[i][j], newColor < 216
//0 <= sr <m
//0 <= sc <n

//可以参考第200题岛屿的数量
//难点：要留一个参数记录初始颜色作为终止条件的判断
public class question733图像渲染 {
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        //记录初始颜色
        int beginColor = image[sr][sc];
        dfs(image, sr, sc, color,beginColor);
        System.out.println(image);
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                System.out.print(image[i][j]);
                if(j== image.length-1){
                    System.out.println("");
                }
            }
        }

        return image;
    }

    public static void dfs(int[][] image,int sr,int sc,int color,int beginColor){
        //如果越界或者返回0
        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] == color || image[sr][sc]!=beginColor ) {
            return;
        }
        image[sr][sc]=color;
        dfs(image,sr,sc-1,color,beginColor);
        dfs(image,sr,sc+1,color,beginColor);
        dfs(image,sr-1,sc,color,beginColor);
        dfs(image,sr+1,sc,color,beginColor);
    }

    public static void main(String[] args) {
        int [][]image = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1;
        int sc = 1;
        int newColor = 2;
        floodFill(image, sr, sc, newColor);
    }
}
