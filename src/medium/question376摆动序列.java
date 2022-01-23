package medium;

//如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。第⼀个差（如果存在
//的话）可能是正数或负数。少于两个元素的序列也是摆动序列。
//例如， [1,7,4,9,2,5] 是⼀个摆动序列，因为差值 (6,-3,5,-7,3) 是正负交替出现的。相反,
//[1,4,7,2,5] 和 [1,7,4,5,5] 不是摆动序列，第⼀个序列是因为它的前两个差值都是正数，第⼆个序列是因
//为它的最后⼀个差值为零。
//给定⼀个整数序列，返回作为摆动序列的最⻓⼦序列的⻓度。 通过从原始序列中删除⼀些（也可以不删
//除）元素来获得⼦序列，剩下的元素保持其原始顺序。
//示例 1:
//输⼊: [1,7,4,9,2,5]
//输出: 6
//解释: 整个序列均为摆动序列。
//class Solution {
//public:
// int findContentChildren(vector<int>& g, vector<int>& s) {
// sort(g.begin(),g.end());
// sort(s.begin(),s.end());
// int index = 0;
// for(int i = 0;i < s.size();++i){
// if(index < g.size() && g[index] <= s[i]){
// index++;
// }
// }
// return index;
// }
//};
//示例 2:
//输⼊: [1,17,5,10,13,15,10,5,16,8]
//输出: 7
//解释: 这个序列包含⼏个⻓度为 7 摆动序列，其中⼀个可为[1,17,10,13,10,16,8]。
//示例 3:
//输⼊: [1,2,3,4,5,6,7,8,9]
//输出: 2

public class question376摆动序列 {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length<=2){
            return nums.length;
        }

        int count=0;
        int i=1;
        int sub=0;
        int nextsub=0;
        while(i<nums.length){
            nextsub = nums[i]-nums[i-1];
            if(sub>0&&(nextsub+sub)<sub){
                count++;
                sub=nextsub;
            }else if(sub<0&&(nextsub+sub)>sub){
                count++;
                sub=nextsub;
            }else{
                sub=nextsub;
            }
            i++;
        }
        return count;
    }
}
