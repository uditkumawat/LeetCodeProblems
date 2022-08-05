package code.top100;

public class SegmentTreeNode {

    public int sum;
    public SegmentTreeNode left,right;
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
