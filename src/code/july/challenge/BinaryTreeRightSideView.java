package code.july.challenge;

import code.facebook.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/binary-tree-right-side-view/submissions/
//TC - O(N)
//SC - O(N)
public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> res = new ArrayList();
        if(root==null){
            return res;
        }

        Queue<TreeNode> q = new LinkedList();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0;i<size;i++){

                TreeNode node = q.remove();

                if(i==size-1){
                    res.add(node.val);
                }

                if(node.left!=null){
                    q.add(node.left);
                }


                if(node.right!=null){
                    q.add(node.right);
                }
            }
        }

        return res;
    }
}
