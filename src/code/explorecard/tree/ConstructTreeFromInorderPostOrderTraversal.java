package code.explorecard.tree;

import code.facebook.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ConstructTreeFromInorderPostOrderTraversal {

    Map<Integer,Integer> indexMap;
    int postIndex;

    public static void main(String args[]){

        int inorder[] = {9,3,15,20,7};
        int postorder[] = {9,15,7,20,3};

        ConstructTreeFromInorderPostOrderTraversal obj = new ConstructTreeFromInorderPostOrderTraversal();

        TreeNode root = obj.buildTree(inorder,postorder);

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        postIndex = postorder.length-1;
        indexMap = new HashMap();
        int i = postorder.length-1;

        int idx = 0;
        for(int num:inorder){
            indexMap.put(num,idx++);
        }

        return buildTreeUtil(inorder,postorder,0,inorder.length-1,indexMap);
    }


    public TreeNode buildTreeUtil(int inorder[],int postorder[],int left,int right,Map<Integer,Integer> indexMap){

        if(left>right){
            return null;
        }

        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);

        int index = indexMap.get(rootVal);

        root.right = buildTreeUtil(inorder,postorder,index+1,right,indexMap);
        root.left = buildTreeUtil(inorder,postorder,left,index-1,indexMap);

        return root;
    }
}
