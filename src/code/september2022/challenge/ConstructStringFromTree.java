package code.september2022.challenge;

import code.facebook.TreeNode;

//https://leetcode.com/problems/construct-string-from-binary-tree/submissions/
//TC - O(N)
//SC - O(N)
public class ConstructStringFromTree {

    public String tree2str(TreeNode root) {

        if(root==null){
            return "()";
        }

        StringBuilder sb = new StringBuilder();
        preOrder(root,sb);
        return sb.toString();
    }

    public void preOrder(TreeNode root,StringBuilder sb){
        if(root==null){
            return;
        }
        sb.append(root.val);

        if(root.left!=null){
            sb.append("(");
            preOrder(root.left,sb);
            sb.append(")");
        }

        if(root.right!=null){
            if(root.left==null){
                sb.append("()");
            }
            sb.append("(");
            preOrder(root.right,sb);
            sb.append(")");
        }
    }
}
