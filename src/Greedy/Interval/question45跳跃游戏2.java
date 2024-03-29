package Greedy.Interval;

//给你一个非负整数数组nums ，你最初位于数组的第一个位置。
//数组中的每个元素代表你在该位置可以跳跃的最大长度。
//你的目标是使用最少的跳跃次数到达数组的最后一个位置。
//假设你总是可以到达数组的最后一个位置。
//
//示例 1:
//
//输入: nums = [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//从下标为 0 跳到下标为 1 的位置，跳1步，然后跳3步到达数组的最后一个位置。
//示例 2:
//
//输入: nums = [2,3,0,1,4]
//输出: 2
//
//提示:
//
//1 <= nums.length <= 104
//0 <= nums[i] <= 1000

public class question45跳跃游戏2 {
    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        int i=1;
        System.out.println(~i);
    }
}
