package code.top100;

/**
 * Time complexity : O(n^2)O(n
 * 2
 *  ). The function construct is called nn times. At each level of the recursive tree, we traverse over all the nn elements to find the maximum element. In the average case, there will be a \log nlogn levels leading to a complexity of O\big(n\log n\big)O(nlogn). In the worst case, the depth of the recursive tree can grow upto nn, which happens in the case of a sorted numsnums array, giving a complexity of O(n^2)O(n
 * 2
 *  ).
 *
 * Space complexity : O(n)O(n). The size of the setset can grow upto nn in the worst case. In the average case, the size will be \log nlogn for nn elements in numsnums, giving an average case complexity of O(\log n)O(logn)
 */
public class MaximumBinaryTree {

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {

        TreeNode root = constructTree(nums,0,nums.length-1);
        return root;
    }

    public TreeNode constructTree(int nums[],int low,int high){
        if(low>high){
            return null;
        }

        int maxIndex = getMaxIndex(nums,low,high);

        TreeNode node = new TreeNode(nums[maxIndex]);
        node.left = constructTree(nums,low,maxIndex-1);
        node.right = constructTree(nums,maxIndex+1,high);

        return node;
    }

    public int getMaxIndex(int nums[],int low,int high){
        int index=-1;
        int max = Integer.MIN_VALUE;
        for(int i=low;i<=high;i++){
            if(max<nums[i]){
                max = nums[i];
                index = i;
            }
        }
        return index;
    }
}
