package code.blind75;

import code.facebook.TreeNode;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/submissions/
//TC - O(N)
//SC - O(N)
public class ConstructBTFromPreorderInorder {

    int preIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        preIndex = 0;

        Map<Integer,Integer> map = new HashMap();

        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        return buildTree(preorder,0,inorder.length-1,map);
    }

    public TreeNode buildTree(int preorder[],int start,int end,Map<Integer,Integer> map){

        if(start>end || preIndex>=preorder.length){
            return null;
        }

        int val = preorder[preIndex];
        preIndex++;

        TreeNode root = new TreeNode(val);

        int inorderIndex = map.get(val);

        root.left = buildTree(preorder,start,inorderIndex-1,map);
        root.right = buildTree(preorder,inorderIndex+1,end,map);

        return root;
    }
}
