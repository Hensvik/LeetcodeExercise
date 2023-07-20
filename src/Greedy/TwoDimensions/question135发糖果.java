package Greedy.TwoDimensions;

//n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
//
//你需要按照以下要求，给这些孩子分发糖果：
//
//每个孩子至少分配到 1 个糖果。
//相邻两个孩子评分更高的孩子会获得更多的糖果。
//请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
//
//示例1：
//
//输入：ratings = [1,0,2]
//输出：5
//解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
//示例2：
//
//输入：ratings = [1,2,2]
//输出：4
//解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
//     第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。

public class question135发糖果 {
    public static int candy(int[] ratings) {
        int []candyVec=new int[ratings.length];
        //全部默认置为1
        for(int i=0;i<candyVec.length;i++){
            candyVec[i]=1;
        }

        //如果右节点大于左节点，则右节点在左节点的基础上+1
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]){
                candyVec[i]=candyVec[i-1]+1;
            }
        }

        //从倒数第二个节点往前遍历，如果左节点比右节点大，那么左节点在右节点的基础上+1
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                //取二者之间的最大值
                candyVec[i] = Math.max(candyVec[i],candyVec[i+1]+1);
            }
        }

        int result=0;
        for(int i=0;i<candyVec.length;i++){
            result +=candyVec[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[]ratings = {1,0,2};
        candy(ratings);
    }
}
