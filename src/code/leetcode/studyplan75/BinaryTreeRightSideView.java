package code.leetcode.studyplan75;

import code.facebook.TreeNode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/binary-tree-right-side-view/submissions/
//TC - O(N)
//SC - O(N)
public class BinaryTreeRightSideView {

    List<Integer> res = new ArrayList();

    public List<Integer> rightSideView(TreeNode root) {

        if(root==null){
            return res;
        }

        helper(root,0);

        return res;
    }

    public void helper(TreeNode root,int level){
        if(level==res.size()){
            res.add(root.val);
        }

        if(root.right!=null){
            helper(root.right,level+1);
        }


        if(root.left!=null){
            helper(root.left,level+1);
        }
    }
}
