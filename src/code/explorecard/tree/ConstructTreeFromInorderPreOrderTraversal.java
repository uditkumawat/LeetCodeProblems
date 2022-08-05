package code.explorecard.tree;

import code.facebook.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/
//tc-O(n)
//sc-O(n)
public class ConstructTreeFromInorderPreOrderTraversal {

    Map<Integer,Integer> indexMap;
    int preIndex;

    public static void main(String args[]){

        int inorder[] = {9,3,15,20,7};
        int preorder[] = {3,9,20,15,7};

        ConstructTreeFromInorderPreOrderTraversal obj = new ConstructTreeFromInorderPreOrderTraversal();

        TreeNode root = obj.buildTree(inorder,preorder);

        obj.printLevelOrder(root);
    }

    public void printLevelOrder(TreeNode root){

        Queue<TreeNode> q = new LinkedList();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                System.out.println(node.val);
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }

            System.out.println();
        }
    }
    public TreeNode buildTree(int[] inorder, int[] preorder) {

        preIndex = 0;
        indexMap = new HashMap();
        int i = preorder.length-1;

        int idx = 0;
        for(int num:inorder){
            indexMap.put(num,idx++);
        }

        return buildTreeUtil(inorder,preorder,0,inorder.length-1,indexMap);
    }


    public TreeNode buildTreeUtil(int inorder[],int preorder[],int left,int right,Map<Integer,Integer> indexMap){

        if(left>right){
            return null;
        }

        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        int index = indexMap.get(rootVal);

        root.left = buildTreeUtil(inorder,preorder,left,index-1,indexMap);
        root.right = buildTreeUtil(inorder,preorder,index+1,right,indexMap);

        return root;
    }
}
