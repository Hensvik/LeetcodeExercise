package Greedy;

//给定一个二叉树，我们在树的节点上安装摄像头。
//节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
//计算监控树的所有节点所需的最小摄像头数量。
//
//示例 1：
//
//输入：[0,0,null,0,0]
//输出：1
//解释：如图所示，一台摄像头足以监控所有节点。
//示例 2：
//
//输入：[0,0,null,0,null,0,null,null,0]
//输出：2
//解释：需要至少两个摄像头来监视树的所有节点。 上图显示了摄像头放置的有效位置之一。
//
//提示：
//
//给定树的节点数的范围是[1, 1000]。
//每个节点的值都是 0。

import Tree.question101对称二叉树;

public class question968监控二叉树 {
    //我们分别有三个数字来表示：
    //
    //0：该节点无覆盖
    //1：本节点有摄像头
    //2：本节点有覆盖

    int result;
    public int minCameraCover(TreeNode root) {
        result = 0;
        if(traversal(root)==0){
            result++;
        }
        return result;
    }

    public int traversal(TreeNode node){
        //空节点，该节点有覆盖
        if(node == null){
            return 2;
        }

        int left = traversal(node.left);
        int right = traversal(node.right);

        //情况1
        //左右节点均有覆盖
        if(left == 2 && right == 2){
            return 0;
        }

        //情况2 只要左右节点有无覆盖的情况，那么当前节点就需要放摄像头
        //left == 0 && right == 0 左右节点无覆盖
        //left == 1 && right == 0 左节点有摄像头，右节点有覆盖
        //left == 0 && right == 1 左节点无覆盖，右节点有摄像头
        //left == 0 && right == 2 左节点无覆盖，右节点覆盖
        //left == 2 && right == 0 左节点覆盖，右节点无覆盖
        if(left == 0 || right == 0){
            result++;
            return 1;
        }

        // 情况3 只要左右节点有摄像头，那么当前节点就是已覆盖
        // left == 1 && right == 2 左节点有摄像头，右节点有覆盖
        // left == 2 && right == 1 左节点有覆盖，右节点有摄像头
        // left == 1 && right == 1 左右节点都有摄像头
        // 其他情况前段代码均已覆盖
        if (left == 1 || right == 1) {
            return 2;
        }

        // 以上代码我没有使用else，主要是为了把各个分支条件展现出来，这样代码有助于读者理解
        // 这个 return -1 逻辑不会走到这里。
        return -1;
    }




    //代码随想录 Java优化法
    int res;
    public int minCameraCover2(TreeNode root) {
        // 对根节点的状态做检验,防止根节点是无覆盖状态 .
        if(minCame(root)==0){
            res++;
        }
        return res;
    }
    /**
     节点的状态值：
     0 表示无覆盖
     1 表示 有摄像头
     2 表示有覆盖
     后序遍历，根据左右节点的情况,来判读 自己的状态
     */
    public int minCame(TreeNode root){
        if(root==null){
            // 空节点默认为 有覆盖状态，避免在叶子节点上放摄像头
            return 2;
        }
        int left=minCame(root.left);
        int  right=minCame(root.right);

        // 如果左右节点都覆盖了的话, 那么本节点的状态就应该是无覆盖,没有摄像头
        if(left==2&&right==2){
            //(2,2)
            return 0;
        }else if(left==0||right==0){
            // 左右节点都是无覆盖状态,那 根节点此时应该放一个摄像头
            // (0,0) (0,1) (0,2) (1,0) (2,0)
            // 状态值为 1 摄像头数 ++;
            res++;
            return 1;
        }else{
            // 左右节点的 状态为 (1,1) (1,2) (2,1) 也就是左右节点至少存在 1个摄像头，
            // 那么本节点就是处于被覆盖状态
            return 2;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
