package code.leetcode.studyplan75;

import code.facebook.TreeNode;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/submissions/
//TC - O(N)
//SC - O(N)
public class ConstructBinaryTreeFromInorderPreorderTraversal {

    int preIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex = 0;

        Map<Integer,Integer> map = new HashMap();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        return buildTreeUtil(preorder,map,0,inorder.length-1);
    }

    public TreeNode buildTreeUtil(int preorder[],Map<Integer,Integer> map,int start,int end){
        if(start>end){
            return null;
        }

        int val = preorder[preIndex];
        TreeNode node = new TreeNode(val);
        preIndex++;
        int index = map.get(val);

        node.left = buildTreeUtil(preorder,map,start,index-1);
        node.right = buildTreeUtil(preorder,map,index+1,end);

        return node;
    }
}
