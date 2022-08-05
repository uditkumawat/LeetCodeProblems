package code.top100;

//https://leetcode.com/problems/range-sum-query-mutable/
public class RangeSumQueryMutable {

    int nums[];
    SegmentTreeNode root;
    RangeSumQueryMutable(int nums[]){
        this.nums = nums;
        root = buildSegmentTree(nums,0,nums.length-1);
    }

    //It has to be build only once
    //TC - O(N)
    public SegmentTreeNode buildSegmentTree(int nums[],int startIndex,int endIndex){
        if(startIndex>endIndex){
            return null;
        }
        else{
            SegmentTreeNode ret = new SegmentTreeNode(startIndex,endIndex);
            //leaf nodes
            if(startIndex==endIndex){
                ret.sum = nums[startIndex];
            }
            else {
                int mid = startIndex + (endIndex - startIndex) / 2;
                ret.left = buildSegmentTree(nums,startIndex,mid);
                ret.right = buildSegmentTree(nums,mid+1,endIndex);
                ret.sum = ret.left.sum + ret.right.sum;
            }
            return ret;
        }
    }

    public static void main(String args[]){

        int num[] = {1,3,5};

        RangeSumQueryMutable obj = new RangeSumQueryMutable(num);
        System.out.println(obj.sumRange(0,2));
        obj.update(1,2);
        System.out.println(obj.sumRange(0,2));
    }

    public int sumRange(int startIndex,int endIndex){
        return sumRangeHelper(root,startIndex,endIndex);
    }

    public int sumRangeHelper(SegmentTreeNode root,int startIndex,int endIndex){
        //if you found out the node that matches your search return its value
        if(root.startIndex == startIndex && root.endIndex == endIndex){
            return root.sum;
        }
        else{
            int mid = root.startIndex + (root.endIndex - root.startIndex)/2;
            //move left
            if(endIndex <= mid){
                return sumRangeHelper(root.left, startIndex, endIndex);
            }
            else if(startIndex >= mid+1){   //move right
                return sumRangeHelper(root.right, startIndex, endIndex);
            }
            else{   //consider both sides
                return sumRangeHelper(root.left, startIndex, mid)+
                        sumRangeHelper(root.right,mid+1, endIndex);
            }
        }
    }

    //TC - O(logN)
    public void update(int index,int val){
        updateHelper(root,index,val);
    }

    public void updateHelper(SegmentTreeNode root,int index,int val){
        //found leaf node to be updated
        if(root.startIndex == root.endIndex){
            root.sum = val;
        }
        else{
            //parent nodes across the path
            int mid = root.startIndex + (root.endIndex-root.startIndex)/2;
            if(index <= mid){
                updateHelper(root.left,index,val);
            }
            else{
                updateHelper(root.right,index,val);
            }
            root.sum = root.left.sum + root.right.sum;
        }
    }



}
