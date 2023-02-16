package Array;

//思路：旋转，保证每一圈写的数字的数量固定，
public class question59螺旋矩阵2 {
    public int[][] generateMatrix(int n) {
        int loop = 0;  // 控制循环次数
        int[][] res = new int[n][n];
        int start = 0;  // 每次循环的开始点(start, start)，每次都是斜对角
        int count = 1;  // 定义填充数字
        int i, j;

        //loop在每次一圈后都会+1
        //假设5x5，那么总共要走两圈
        while (loop++ < n / 2) { //判断边界后，loop从0开始
            // 模拟上侧从左到右
            for (j = start; j < n - loop; j++) {
                res[start][j] = count++;
            }

            // 模拟右侧从上到下
            for (i = start; i < n - loop; i++) {
                res[i][j] = count++;
            }

            // 模拟下侧从右到左
            for (; j >= loop; j--) {
                res[i][j] = count++;
            }

            // 模拟左侧从下到上
            for (; i >= loop; i--) {
                res[i][j] = count++;
            }
            //因为start节点每次是斜对角，所以需要+1
            start++;
        }

        //如果n是奇数的话，最后还有中间1个点
        if (n % 2 == 1) {
            res[start][start] = count;
        }

        return res;
    }
}
