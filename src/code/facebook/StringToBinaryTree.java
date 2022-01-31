package code.facebook;

import java.util.Stack;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-string/
 */
public class StringToBinaryTree {

    public static void main(String args[]){

        String s = "4(2(3)(1))(6(5))";

        StringToBinaryTree obj = new StringToBinaryTree();

        TreeNode root = obj.str2Tree(s);

        obj.preorder(root);

        return;
    }

    public void preorder(TreeNode root){
        if(root==null){
            return;
        }
        System.out.print(root.val+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public TreeNode str2Tree(String s){

        Stack<TreeNode> stack = new Stack<>();
        TreeNode parent = null;
        TreeNode currNode = null;
        int sign = 1;
        int si = 0;

        while(si<s.length()){
            if(s.charAt(si)=='-'){
                sign=-1;
                si++;
            }
            else if(s.charAt(si)=='('){
                si++;
            }else if(s.charAt(si)>='0' && s.charAt(si)<='9'){
                int num = 0;
                while(si<s.length() && s.charAt(si)>='0' && s.charAt(si)<='9'){
                    num = num*10 + s.charAt(si)-'0';
                    si++;
                }
                num = num*sign;
                sign = 1;
                stack.push(new TreeNode(num));
            }
            else if(s.charAt(si)==')'){
                currNode = stack.pop();
                parent = stack.peek();
                if(parent.left!=null){
                    parent.right = currNode;
                }
                else{
                    parent.left = currNode;
                }
                si++;
            }
        }

        if(!stack.isEmpty()){
            return stack.pop();
        }

        return parent;
    }
}
