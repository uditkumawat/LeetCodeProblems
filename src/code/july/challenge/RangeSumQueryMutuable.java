package code.july.challenge;

//https://leetcode.com/problems/range-sum-query-mutable/submissions/
public class RangeSumQueryMutuable {

    class SegmentTreeNode{
        public int sum;
        public SegmentTreeNode left;
        public SegmentTreeNode right;
        public int startIndex;
        public int endIndex;
        SegmentTreeNode(int startIndex,int endIndex){
            this.startIndex = startIndex;
            this.endIndex = endIndex;
            this.left = null;
            this.right = null;
            this.sum = 0;
        }
    }

    SegmentTreeNode root;

    public RangeSumQueryMutuable(int[] nums) {

        if(nums==null || nums.length==0){
            return;
        }

        root = buildSegmentTree(nums,0,nums.length-1);
    }

    public SegmentTreeNode buildSegmentTree(int nums[],int startIndex,int endIndex){
        if(startIndex>endIndex){
            return null;
        }
        SegmentTreeNode node = new SegmentTreeNode(startIndex,endIndex);
        if(startIndex == endIndex){
            node.sum = nums[startIndex];
        }
        else{
            int mid = startIndex+(endIndex-startIndex)/2;
            node.left = buildSegmentTree(nums,startIndex,mid);
            node.right = buildSegmentTree(nums,mid+1,endIndex);
            node.sum = node.left.sum + node.right.sum;
        }
        return node;
    }

    public void update(int index, int val) {
        updateHelper(root,index,val);
    }

    private void updateHelper(SegmentTreeNode root,int index,int val){
        if(root.startIndex==root.endIndex){
            root.sum = val;
            return;
        }
        else{
            int mid = root.startIndex + (root.endIndex-root.startIndex)/2;
            if(index<=mid){
                updateHelper(root.left,index,val);
            }else{
                updateHelper(root.right,index,val);
            }
            root.sum = root.left.sum + root.right.sum;
        }
    }

    public int sumRange(int left, int right) {
        return sumRangeHelper(root,left,right);
    }

    private int sumRangeHelper(SegmentTreeNode root,int left,int right){
        if(root.startIndex==left && root.endIndex==right){
            return root.sum;
        }
        else{
            int mid = root.startIndex + (root.endIndex-root.startIndex)/2;
            if(mid>=right){
                return sumRangeHelper(root.left,left,right);
            }
            else if(left>=(mid+1)){
                return sumRangeHelper(root.right,left,right);
            }
            else{
                return sumRangeHelper(root.left,left,mid)+sumRangeHelper(root.right,mid+1,right);
            }

        }
    }
}
