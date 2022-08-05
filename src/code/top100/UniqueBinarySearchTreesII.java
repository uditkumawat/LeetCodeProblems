package code.top100;

import code.facebook.TreeNode;

import java.util.ArrayList;
import java.util.List;

//https://www.youtube.com/watch?v=mhCJgZWJlSI
public class UniqueBinarySearchTreesII {

    public static void main(String args[]){

        int n = 3;

        UniqueBinarySearchTreesII obj = new UniqueBinarySearchTreesII();
        List<TreeNode> res = obj.helper(1,3);

        for(TreeNode node:res){
            System.out.println(node.val);
        }
    }

    public List<TreeNode> helper(int start,int end){
        List<TreeNode> list = new ArrayList<>();

        if(start>end){
            list.add(null);
            return list;
        }

        if(start==end){
            list.add(new TreeNode(start));
            return list;
        }

        for(int i=start;i<=end;i++){
            List<TreeNode> leftSubTrees = helper(start,i-1);
            List<TreeNode> rightSubTrees = helper(i+1,end);

            for(TreeNode leftRoot:leftSubTrees){
                for(TreeNode rightRoot:rightSubTrees){

                    TreeNode root = new TreeNode(i);
                    root.left = leftRoot;
                    root.right = rightRoot;
                    list.add(root);
                }
            }
        }

        return list;
    }
}
